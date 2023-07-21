package com.adem.todoist.service;

import com.adem.todoist.entity.Member;

import java.util.UUID;

public interface MemberService {
    Member getByUid(UUID memberUid);
}
