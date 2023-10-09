package com.preliminary_task.preliminary_task.recruitment.controller;

import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentPatchDto;
import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentPostDto;
import com.preliminary_task.preliminary_task.recruitment.entity.Recruitment;
import com.preliminary_task.preliminary_task.recruitment.mapper.RecruitmentMapper;
import com.preliminary_task.preliminary_task.recruitment.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/recruitments")
public class RecruitmentController {
    private final RecruitmentService recruitmentService;
    private final RecruitmentMapper mapper;

    //채용공고를 등록합니다.
    @PostMapping("/new-announcement")
    public ResponseEntity postRecruitment(@Valid @RequestBody RecruitmentPostDto postDto){

        Recruitment recruitment = mapper.postDtoToRecruitment(postDto);
        Recruitment createRecruitment = recruitmentService.createRecruitment(recruitment);
        return new ResponseEntity<>(mapper.recruitmentToResponseDto(createRecruitment), HttpStatus.CREATED);
    }

    //채용공고를 수정합니다.
    @PatchMapping("/{recruitmentId}")
    public ResponseEntity patchRecruitment (@PathVariable long recruitmentId ,
                                            @RequestBody RecruitmentPatchDto patchDto){
        patchDto.setRecruitmentId(recruitmentId);
        Recruitment recruitment = mapper.patchDtoToRecruitment(patchDto);
        Recruitment updateRecruitment = recruitmentService.updateRecruitment(recruitment);
        return new ResponseEntity<>(mapper.recruitmentToResponseDto(updateRecruitment), HttpStatus.OK);
    }

    //채용공고를 불러옵니다.

    //채용공고를 삭제합니다.
}
