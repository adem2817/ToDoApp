package com.adem.todoist.repository;

import com.adem.todoist.entity.Note;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {

    Note findByUidAndMember_Uid(UUID uid, UUID memberUid);
    List<Note> findAllByMember_Uid(UUID memberUid);
}
