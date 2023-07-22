package com.adem.todoist.service;

import com.adem.todoist.entity.NoteBook;
import com.adem.todoist.repository.NoteBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoteBookServiceImpl implements NoteBookService{

    private final NoteBookRepository noteBookRepository;

    @Override
    public List<NoteBook> getAllNotebooks(UUID member) {
        return noteBookRepository.findAllByMemberUid(member);
    }

    @Override
    public NoteBook getNoteBookByUid(UUID uid, UUID member) {
        return noteBookRepository.findByUidAndMemberUid(uid, member);
    }

    @Override
    public NoteBook getByUid(UUID uid) {
        return noteBookRepository.findByUid(uid);
    }

    @Override
    public void save(NoteBook notebook) {
        noteBookRepository.save(notebook);
    }

    @Override
    public void delete(NoteBook notebook) {
        noteBookRepository.delete(notebook);
    }
}
