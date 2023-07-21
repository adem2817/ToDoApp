package com.adem.todoist.service;

import com.adem.todoist.entity.NoteBook;

import java.util.List;
import java.util.UUID;

public interface NoteBookService {
    List<NoteBook> getAllNotebooks(UUID member);
    NoteBook getNoteBookByUid(UUID uid, UUID member);
    NoteBook getByUid(UUID uid);
    void save(NoteBook note);
    void delete(NoteBook note);
}
