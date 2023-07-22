package com.adem.todoist.repository;

import com.adem.todoist.entity.Note;
import com.adem.todoist.entity.NoteBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface NoteBookRepository extends CrudRepository<NoteBook, String> {

    NoteBook findByUidAndMemberUid(UUID uid, UUID memberUid);

    List<NoteBook> findAllByMemberUid(UUID memberUid);


    NoteBook findByUid(UUID uid);
}
