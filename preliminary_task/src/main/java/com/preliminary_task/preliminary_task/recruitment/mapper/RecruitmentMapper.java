package com.preliminary_task.preliminary_task.recruitment.mapper;


import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentListResponseDto;
import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentPatchDto;
import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentPostDto;
import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentDetailResponseDto;
import com.preliminary_task.preliminary_task.recruitment.entity.Recruitment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecruitmentMapper {

    @Mapping(source = "companyId", target = "company.companyId")
    Recruitment postDtoToRecruitment (RecruitmentPostDto postDto);

    Recruitment patchDtoToRecruitment(RecruitmentPatchDto patchDto);

//    @Mapping(source = "company.companyName", target = "companyName")
//    @Mapping(source = "company.nation", target = "nation")
//    @Mapping(source = "company.region", target = "region")
//    @Mapping(source = "c.recruitments", target = "otherRecruitments")
//    RecruitmentDetailResponseDto recruitmentToDetailResponseDto(Recruitment recruitment);

    @Mapping(source = "company.companyName", target = "companyName")
    @Mapping(source = "company.nation", target = "nation")
    @Mapping(source = "company.region", target = "region")
    RecruitmentListResponseDto recruitmentToListResponseDto(Recruitment recruitment);

    List<RecruitmentListResponseDto> recruitmentToListResponseDto (List<Recruitment> recruitmentList);

}
