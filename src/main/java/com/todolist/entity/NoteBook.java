package com.todolist.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class NoteBook extends BaseEntity {
    @Id
    @Field
    private Long id;
    @Field
    private UUID uid;
    @Field
    private String name;
    @Field
    private Set<Note> notes;
    @Field
    private UUID memberUid;
}
