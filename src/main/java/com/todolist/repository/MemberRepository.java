package com.todolist.repository;

import com.todolist.entity.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
    Member findByUid(UUID uid);
}
