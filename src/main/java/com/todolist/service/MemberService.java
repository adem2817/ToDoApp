package com.todolist.service;

import com.todolist.entity.Member;

import java.util.UUID;

public interface MemberService {
    Member getByUid(UUID memberUid);
}
