package com.adem.todoist.repository;

import com.adem.todoist.entity.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
    Member findByUid(UUID uid);
}
