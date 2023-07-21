package com.adem.todoist.service;

import com.adem.todoist.entity.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    List<Note> getAllNotes(UUID memberUid);
    List<Note> getAllNotesByMember_UidAndNotebook_Uid(UUID memberUid, UUID notebookUid);
    Note getNoteByUid(UUID uid, UUID member);
    Note getByUid(UUID uid);
    void save(Note note);
    void delete(Note note);
}
