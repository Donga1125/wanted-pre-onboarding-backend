package com.preliminary_task.preliminary_task.recruitment.mapper;


import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentPatchDto;
import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentPostDto;
import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentResponseDto;
import com.preliminary_task.preliminary_task.recruitment.entity.Recruitment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecruitmentMapper {

    @Mapping(source = "companyId", target = "company.companyId")
    Recruitment postDtoToRecruitment (RecruitmentPostDto postDto);

    Recruitment patchDtoToRecruitment(RecruitmentPatchDto patchDto);

    RecruitmentResponseDto recruitmentToResponseDto (Recruitment recruitment);


}
