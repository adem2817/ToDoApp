package com.todolist.repository;

import com.todolist.entity.NoteBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface NoteBookRepository extends CrudRepository<NoteBook, String> {

    NoteBook findByUidAndMemberUid(UUID uid, UUID memberUid);

    List<NoteBook> findAllByMemberUid(UUID memberUid);


    NoteBook findByUid(UUID uid);
}
