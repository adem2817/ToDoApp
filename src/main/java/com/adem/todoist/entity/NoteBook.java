package com.adem.todoist.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteBook extends BaseEntity {
    @Id
    private Long id;
    private UUID uid;
    private String name;
    private List<Note> notes;
    private Member member;
}
