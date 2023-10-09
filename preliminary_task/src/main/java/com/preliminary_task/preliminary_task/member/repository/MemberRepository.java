package com.preliminary_task.preliminary_task.member.repository;

import com.preliminary_task.preliminary_task.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
