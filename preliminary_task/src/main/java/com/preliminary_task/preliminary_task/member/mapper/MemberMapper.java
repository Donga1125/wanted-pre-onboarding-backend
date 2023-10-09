package com.preliminary_task.preliminary_task.member.mapper;

import com.preliminary_task.preliminary_task.member.dto.MemberPostDto;
import com.preliminary_task.preliminary_task.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember (MemberPostDto postDto);
}
