package com.todolist.repository;

import com.todolist.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends CrudRepository<Note, String> {

    List<Note> findByNotebookUidAndMemberUid(UUID notebookUid, UUID memberUid);
    Note findByUidAndMemberUid(UUID noteUid, UUID memberUid);

    List<Note> findAllByMemberUid(UUID memberUid);

    Note findByUid(UUID uid);

}
