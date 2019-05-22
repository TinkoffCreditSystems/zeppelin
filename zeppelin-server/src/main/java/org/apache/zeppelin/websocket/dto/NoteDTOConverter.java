/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.zeppelin.websocket.dto;

import org.springframework.stereotype.Component;
import ru.tinkoff.zeppelin.core.externalDTO.InterpreterResultDTO;
import ru.tinkoff.zeppelin.core.externalDTO.NoteDTO;
import ru.tinkoff.zeppelin.core.externalDTO.ParagraphDTO;
import ru.tinkoff.zeppelin.core.notebook.Note;
import ru.tinkoff.zeppelin.core.notebook.Paragraph;
import ru.tinkoff.zeppelin.engine.NoteService;
import ru.tinkoff.zeppelin.storage.*;

import java.util.List;


@Component
public class NoteDTOConverter {

    private final JobBatchDAO jobBatchDAO;
    private final JobDAO jobDAO;
    private final JobPayloadDAO jobPayloadDAO;
    private final JobResultDAO jobResultDAO;
    private final NoteService noteService;

    private final FullParagraphDAO fullParagraphDAO;

    public NoteDTOConverter(JobBatchDAO jobBatchDAO,
                            JobDAO jobDAO,
                            JobPayloadDAO jobPayloadDAO,
                            JobResultDAO jobResultDAO,
                            NoteService noteService,
                            FullParagraphDAO fullParagraphDAO) {
        this.jobBatchDAO = jobBatchDAO;
        this.jobDAO = jobDAO;
        this.jobPayloadDAO = jobPayloadDAO;
        this.jobResultDAO = jobResultDAO;
        this.noteService = noteService;
        this.fullParagraphDAO = fullParagraphDAO;
    }

    public NoteDTO convertNoteToDTO(final Note note) {
        final NoteDTO noteDTO = new NoteDTO();
        noteDTO.setDatabaseId(note.getId());
        noteDTO.setId(note.getUuid());
        noteDTO.setName(note.getName());
        noteDTO.setPath(note.getPath());
        noteDTO.setRevision(note.getRevision());
        noteDTO.setFormParams(note.getFormParams());
        for (final Paragraph p : noteService.getParagraphs(note)) {
            final ParagraphDTO paragraphDAO = fullParagraphDAO.getById(p.getId());

            if (paragraphDAO.getResults() == null) {
                paragraphDAO.setResults(new InterpreterResultDTO());
            }

            // add message if messages list is empty
            final List<InterpreterResultDTO.Message> messages = paragraphDAO.getResults().getMsg();
            if (messages.size() == 0) {
                messages.add(new InterpreterResultDTO.Message("TEXT", ""));
            }

            noteDTO.getParagraphs().add(paragraphDAO);
        }
        noteDTO.setScheduler(note.getScheduler());
        noteDTO.getConfig().put("looknfeel", false);

        return noteDTO;
    }
}


