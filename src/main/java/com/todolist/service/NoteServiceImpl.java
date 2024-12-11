package com.todolist.service;

import com.todolist.entity.Note;
import com.todolist.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes(UUID memberUid) {
        return noteRepository.findAllByMemberUid(memberUid);
    }

    @Override
    public List<Note> getAllNotesByNotebook_UidAndMember_Uid(UUID notebookUid, UUID memberUid) {
        return noteRepository.findByNotebookUidAndMemberUid(notebookUid, memberUid);
    }

    @Override
    public Note getNoteByUid(UUID uid, UUID member) {
        return noteRepository.findByUidAndMemberUid(uid, member);
    }

    @Override
    public Note getByUid(UUID uid) {
        return noteRepository.findByUid(uid);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void delete(Note note) {
        noteRepository.delete(note);
    }
}
