package com.todolist.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Note extends BaseEntity{
    @Id
    @Field
    private Long id;
    @Field
    private UUID uid;
    @Field
    private UUID notebookUid;
    @Field
    private String content = "";
    @Field
    private Boolean status = false;
    @Field
    private UUID memberUid;
}
