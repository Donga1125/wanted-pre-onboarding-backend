package com.preliminary_task.preliminary_task.member.service;


import com.preliminary_task.preliminary_task.member.entity.Member;
import com.preliminary_task.preliminary_task.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    //멤버를 등록합니다
    public Member createMember (Member member){
        return memberRepository.save(member);
    }
}
