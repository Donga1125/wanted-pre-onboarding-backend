package com.preliminary_task.preliminary_task.member.controller;


import com.preliminary_task.preliminary_task.member.dto.MemberPostDto;
import com.preliminary_task.preliminary_task.member.entity.Member;
import com.preliminary_task.preliminary_task.member.mapper.MemberMapper;
import com.preliminary_task.preliminary_task.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberController {
    private final MemberMapper mapper;
    private final MemberService memberService;

   //회원을 등록합니다.
    @PostMapping("/new-member")
    public ResponseEntity postMember (@RequestBody MemberPostDto postDto){
        Member member = mapper.memberPostDtoToMember(postDto);
        Member createMember =  memberService.createMember(member);

        return new ResponseEntity<>(createMember, HttpStatus.CREATED);
    }
}
