package org.apache.zeppelin;

import org.apache.zeppelin.interpreter.configuration.InterpreterOption;
import org.apache.zeppelin.interpreter.core.InterpreterResult;
import org.apache.zeppelin.interpreter.core.thrift.PushResult;
import org.apache.zeppelin.interpreterV2.server.InterpreterProcess;
import org.apache.zeppelin.interpreterV2.server.InterpreterProcessServerManager;
import org.apache.zeppelin.notebook.*;
import org.apache.zeppelin.storage.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class NoteExecutorService {

  private final JobBatchDAO jobBatchDAO;
  private final JobDAO jobDAO;
  private final JobPayloadDAO jobPayloadDAO;
  private final JobResultDAO jobResultDAO;
  private final InterpreterOptionRepository interpreterOptionRepository;

  private final InterpreterProcessServerManager serverManager;

  public NoteExecutorService(final JobBatchDAO jobBatchDAO,
                             final JobDAO jobDAO,
                             final JobPayloadDAO jobPayloadDAO,
                             final JobResultDAO jobResultDAO,
                             final InterpreterOptionRepository interpreterOptionRepository) {
    this.jobBatchDAO = jobBatchDAO;
    this.jobDAO = jobDAO;
    this.jobPayloadDAO = jobPayloadDAO;
    this.jobResultDAO = jobResultDAO;
    this.interpreterOptionRepository = interpreterOptionRepository;
    this.serverManager = new InterpreterProcessServerManager(interpreterOptionRepository, this::handleInterpreterResult);

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    executorService.execute(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            handleNextReady();

            try {
              Thread.sleep(5000);
            } catch (Exception e) {
              String sdfsdf = "";
            }
          } catch (Exception e) {
            e.printStackTrace();
            //skip
          }
        }
      }
    });
  }

  @PostConstruct
  public void postConstruct() {
    try {
      serverManager.startServer();

    } catch (final Exception e) {

    }
  }

  @PreDestroy
  public void preDestroy() {
    serverManager.stopServer();
  }


  public void run(final Note note) {
    final JobBatch batch = new JobBatch();
    batch.setId(0L);
    batch.setNoteId(note.getDatabaseId());
    batch.setStatus(JobBatch.Status.SAVING);
    batch.setCreatedAt(LocalDateTime.now());
    batch.setStartedAt(null);
    batch.setEndedAt(null);
    final JobBatch saved = jobBatchDAO.persist(batch);

    for (int i = 0; i < note.getParagraphs().size(); i++) {
      final Paragraph p = note.getParagraphs().get(i);

      final Job job = new Job();
      job.setId(0L);
      job.setBatchId(saved.getId());
      job.setNoteId(note.getDatabaseId());
      job.setParagpaphId(p.getDatabaseId());
      job.setIndex(i);
      job.setShebang(getShebang(p));
      job.setStatus(Job.Status.PENDING);
      job.setInterpreterProcessUUID(null);
      job.setInterpreterJobUUID(null);
      job.setCreatedAt(LocalDateTime.now());
      job.setStartedAt(null);
      job.setEndedAt(null);
      jobDAO.persist(job);

      final JobPayload jobPayload = new JobPayload();
      jobPayload.setId(0L);
      jobPayload.setJobId(job.getId());
      jobPayload.setPayload(getPayload(p));
      jobPayloadDAO.persist(jobPayload);
    }
    saved.setStatus(JobBatch.Status.PENDING);
    jobBatchDAO.update(saved);
  }


  private synchronized void handleNextReady() {

    final List<Job> jobs = jobDAO.loadNextReady();
    for (final Job job : jobs) {
      final String shebang = job.getShebang();

      final InterpreterOption interpreterOption = interpreterOptionRepository.getOption(shebang);
      if(interpreterOption == null) {
        //TODO int not found
        continue;
      }

      final InterpreterProcess remote = serverManager.getRemote(shebang, interpreterOption);
      if (remote.getStatus() == InterpreterProcess.Status.READY) {

        // prepare payload
        final String payload = jobPayloadDAO.getByJobId(job.getId()).getPayload();

        // prepare notecontext
        final Map<String, String> noteContext = new HashMap<>();
        noteContext.put("noteId", String.valueOf(job.getNoteId()));
        noteContext.put("paragraphId", String.valueOf(job.getParagpaphId()));

        // prepare usercontext
        final Map<String, String> userContext = new HashMap<>();

        // prepare configuration
        final Map<String, String> configuration = new HashMap<>();
        remote.getConfig()
                .getConfig()
                .getProperties()
                .forEach((p, v) -> configuration.put(p, String.valueOf(v.getCurrentValue())));

        final PushResult result;
        try {
          result = remote.getConnection().push(payload, noteContext, userContext, configuration);
          if (result == null) {
            throw new IllegalArgumentException("Error while send data to interpreter");
          }
        } catch (final Exception e) {
          //busyInterpreters.add(job.getShebang());
          // TODO: shutdown interpreter process
          break;
        }

        switch (result.getStatus()) {
          case "ACCEPT":
            final JobBatch jobBatch = jobBatchDAO.get(job.getBatchId());
            if (jobBatch.getStatus() == JobBatch.Status.PENDING) {
              jobBatch.setStatus(JobBatch.Status.RUNNING);
              jobBatch.setStartedAt(LocalDateTime.now());
              jobBatchDAO.update(jobBatch);
              // TODO: notify web UI
            }

            job.setStatus(Job.Status.RUNNING);
            job.setInterpreterProcessUUID(result.getInterpreterProcessUUID());
            job.setInterpreterJobUUID(result.getInterpreterJobUUID());
            jobDAO.update(job);
            // TODO: notify web UI
            break;
          case "BUSY":
            //busyInterpreters.add(job.getShebang());
            break;
          default:
            //busyInterpreters.add(job.getShebang());
            // TODO: shutdown interpreter process
        }
      }

      if (remote.getStatus() == InterpreterProcess.Status.NOT_FOUND) {
        //TODO: implement this
      }

      if (remote.getStatus() == InterpreterProcess.Status.STARTING) {
        // do nothing
        // whait
      }
    }
  }

  private synchronized void handleInterpreterResult(final String interpreterJobUUID, final InterpreterResult interpreterResult) {
    final Job job = jobDAO.getByInterpreterJobUUID(interpreterJobUUID);
    if (job == null) {
      return;
    }

    for (final InterpreterResult.Message message : interpreterResult.message()) {
      final JobResult jobResult = new JobResult();
      jobResult.setJobId(job.getId());
      jobResult.setCreatedAt(LocalDateTime.now());
      jobResult.setType(message.getType().name());
      jobResult.setResult(message.getData());
      jobResultDAO.persist(jobResult);
    }
    switch (interpreterResult.code()) {
      case SUCCESS:
      case KEEP_PREVIOUS_RESULT:
        job.setStatus(Job.Status.DONE);
        job.setEndedAt(LocalDateTime.now());
        jobDAO.update(job);
        break;
      case ERROR:
      case INCOMPLETE:
        job.setStatus(Job.Status.ERROR);
        job.setEndedAt(LocalDateTime.now());
        jobDAO.update(job);

        final JobBatch batch = jobBatchDAO.get(job.getBatchId());
        final List<Job> jobs = jobDAO.loadByBatch(job.getBatchId());
        for (final Job j : jobs) {
          if(j.getStatus() != Job.Status.PENDING) {
            continue;
          }
          j.setStatus(Job.Status.CANCELED);
          j.setEndedAt(LocalDateTime.now());
          jobDAO.update(j);
        }
        batch.setStatus(JobBatch.Status.ERROR);
        batch.setEndedAt(LocalDateTime.now());
        jobBatchDAO.update(batch);
    }
  }


  private String getShebang(final Paragraph p) {
    return "%md";
  }

  private String getPayload(final Paragraph p) {
    return "PAYLOAD";
  }
}
