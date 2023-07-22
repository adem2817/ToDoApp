package com.adem.todoist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity{
    @Id
    private Long id;
    private UUID uid;
    private String name;
    private String email;
    private String password;
    private List<UUID> noteBookUids;
}
