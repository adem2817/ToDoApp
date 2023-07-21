package com.adem.todoist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    private Date createdDate;
    private Date updatedDate;
    private Long createdBy;
    private Long updatedBy;
    private Long version;

}
