package com.adem.todoist.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note extends BaseEntity{
    @Id
    private Long id;
    private UUID uid;
    private String content = "";
    private Boolean status = false;
}
