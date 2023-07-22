package com.adem.todoist.controller;

import com.adem.todoist.entity.Member;
import com.adem.todoist.entity.NoteBook;
import com.adem.todoist.model.NoteBookModel;
import com.adem.todoist.service.MemberService;
import com.adem.todoist.service.NoteBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/notebook")
public class NoteBookController {

    private final NoteBookService noteBookService;
    private final MemberService memberService;

    @GetMapping("/member/{member-uid}")
    public ResponseEntity<List<NoteBook>> list(@PathVariable(value = "member-uid") UUID memberUid) {
        List<NoteBook> noteBooks = noteBookService.getAllNotebooks(memberUid);
        if (noteBooks.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(noteBooks);
    }

    @GetMapping("/{notebook-uid}/member/{member-uid}")
    public ResponseEntity<NoteBook> get(@PathVariable("notebook-uid") UUID noteUid, @PathVariable(value = "member-uid") UUID memberUid) {
        NoteBook noteBook = noteBookService.getNoteBookByUid(noteUid, memberUid);
        if (noteBook == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(noteBook);
    }

    @PostMapping("/member/{member-uid}")
    public ResponseEntity add(@PathVariable(value = "member-uid") UUID memberUid, @RequestBody NoteBookModel noteBookModel) {
        Member member = memberService.getByUid(memberUid);
        NoteBook noteBook = NoteBook.builder()
                .name(noteBookModel.getName())
                .uid(UUID.randomUUID())
                .memberUid(member.getUid())
                .build();
        noteBookService.save(noteBook);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{notebook-uid}/member/{member-uid}")
    public ResponseEntity update(@PathVariable(value = "member-uid") UUID memberUid, @PathVariable("notebook-uid") UUID noteUid, @RequestBody NoteBookModel noteBookModel) {
        NoteBook noteBook = noteBookService.getNoteBookByUid(noteUid, memberUid);
        if (noteBook == null)
            return ResponseEntity.notFound().build();
        noteBook.setName(noteBookModel.getName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{notebook-uid}")
    public ResponseEntity delete(@PathVariable("notebook-uid") UUID noteBookUid) {
        NoteBook noteBook = noteBookService.getByUid(noteBookUid);
        if (noteBook == null)
            return ResponseEntity.notFound().build();
        noteBookService.delete(noteBook);
        return ResponseEntity.noContent().build();
    }
}

