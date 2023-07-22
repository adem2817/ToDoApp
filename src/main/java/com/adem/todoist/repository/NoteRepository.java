package com.adem.todoist.repository;

import com.adem.todoist.entity.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends CrudRepository<Note, String> {

    List<Note> findByNotebookUidAndMemberUid(UUID notebookUid, UUID memberUid);
    Note findByUidAndMemberUid(UUID noteUid, UUID memberUid);

    List<Note> findAllByMemberUid(UUID memberUid);

    Note findByUid(UUID uid);

}
