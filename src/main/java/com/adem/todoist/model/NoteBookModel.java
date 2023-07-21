package com.adem.todoist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteBookModel {
    private UUID uid;
    private String name;
    private List<UUID> noteUids;
    private UUID memberUid;
}
