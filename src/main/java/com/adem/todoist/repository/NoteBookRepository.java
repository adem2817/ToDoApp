package com.adem.todoist.repository;

import com.adem.todoist.entity.NoteBook;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface NoteBookRepository extends PagingAndSortingRepository<NoteBook, Long> {

    NoteBook findByUidAndMember_Uid(UUID uid, UUID memberUid);
    List<NoteBook> findAllByMember_Uid(UUID memberUid);
}
