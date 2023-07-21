package com.adem.todoist.controller;

import com.adem.todoist.entity.Member;
import com.adem.todoist.entity.Note;
import com.adem.todoist.model.NoteModel;
import com.adem.todoist.service.MemberService;
import com.adem.todoist.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;
    private final MemberService memberService;

    @GetMapping("/member/{member-uid}/notebook/{notebook-uid}")
    public ResponseEntity<List<Note>> list(@PathVariable(value = "member-uid") UUID memberUid, @PathVariable(value = "notebook-uid") UUID notebookUid) {
        List<Note> notes = noteService.getAllNotesByMember_UidAndNotebook_Uid(memberUid, notebookUid);
        if (notes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{note-uid}/member/{member-uid}")
    public ResponseEntity<Note> get(@PathVariable("note-uid") UUID noteUid, @PathVariable(value = "member-uid") UUID memberUid) {
        Note note = noteService.getNoteByUid(noteUid, memberUid);
        if (note == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(note);
    }

    @PostMapping("/member/{member-uid}")
    public ResponseEntity add(@PathVariable(value = "member-uid") UUID memberUid, @RequestBody NoteModel noteModel) {
        Member member = memberService.getByUid(memberUid);
        Note note = Note.builder()
                .uid(UUID.randomUUID())
                .content(noteModel.getContent())
                .status(false)
                .build();
        noteService.save(note);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{note-uid}/member/{member-uid}")
    public ResponseEntity update(@PathVariable(value = "member-uid") UUID memberUid, @PathVariable("note-uid") UUID noteUid, @RequestBody NoteModel noteModel) {
        Note note = noteService.getNoteByUid(noteUid, memberUid);
        if (note == null)
            return ResponseEntity.notFound().build();
        note.setContent(noteModel.getContent());
        note.setStatus(noteModel.getStatus());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{note-uid}")
    public ResponseEntity delete(@PathVariable("note-uid") UUID noteUid) {
        Note note = noteService.getByUid(noteUid);
        if (note == null)
            return ResponseEntity.notFound().build();
        noteService.delete(note);
        return ResponseEntity.noContent().build();
    }
}
