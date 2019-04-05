package org.apache.zeppelin.interpreterV2.handler;

import org.apache.zeppelin.storage.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class InterpreterDeadHandler extends AbstractHandler {

  public InterpreterDeadHandler(final JobBatchDAO jobBatchDAO,
                                final JobDAO jobDAO,
                                final JobResultDAO jobResultDAO,
                                final JobPayloadDAO jobPayloadDAO,
                                final NoteDAO noteDAO,
                                final ParagraphDAO paragraphDAO,
                                final FullParagraphDAO fullParagraphDAO) {
    super(jobBatchDAO, jobDAO, jobResultDAO, jobPayloadDAO, noteDAO, paragraphDAO, fullParagraphDAO);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void handle(final List<String> liveInterpreters) {
    liveInterpreters.add("__DEFAULT__");
    jobDAO.restoreState(liveInterpreters);
  }

}
