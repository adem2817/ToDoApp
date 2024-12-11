package com.todolist.model;

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
public class MemberModel {
    private UUID uid;
    private String name;
    private String email;
    private String password;
    private List<UUID> noteBookUids;
}
