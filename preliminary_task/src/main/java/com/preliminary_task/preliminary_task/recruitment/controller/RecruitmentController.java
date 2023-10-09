package com.preliminary_task.preliminary_task.recruitment.controller;

import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentDetailResponseDto;
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
import java.util.List;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/recruitments")
public class RecruitmentController {
    private final RecruitmentService recruitmentService;
    private final RecruitmentMapper mapper;

    //채용공고를 등록합니다.
    @PostMapping("/new-announcement/{companyId}")
    public ResponseEntity postRecruitment(@PathVariable long companyId,
                                          @Valid @RequestBody RecruitmentPostDto postDto){
        postDto.setCompanyId(companyId);
        Recruitment recruitment = mapper.postDtoToRecruitment(postDto);
        Recruitment createRecruitment = recruitmentService.createRecruitment(recruitment);
        return new ResponseEntity<>(createRecruitment, HttpStatus.CREATED);
    }

    //채용공고를 수정합니다.
    @PatchMapping("/{recruitmentId}")
    public ResponseEntity patchRecruitment (@PathVariable long recruitmentId ,
                                            @RequestBody RecruitmentPatchDto patchDto){
        patchDto.setRecruitmentId(recruitmentId);
        Recruitment recruitment = mapper.patchDtoToRecruitment(patchDto);
        Recruitment updateRecruitment = recruitmentService.updateRecruitment(recruitment);
        return new ResponseEntity<>(updateRecruitment, HttpStatus.OK);
    }

    //채용공고를 목록을 조회합니다.
    @GetMapping
    public ResponseEntity getAllRecruitment (){
        List<Recruitment> findAllRecruitment = recruitmentService.findAllRecruitment();
        return new ResponseEntity<>(mapper.recruitmentToListResponseDto(findAllRecruitment), HttpStatus.OK);
    }

    //특정 채용공고 상세내용를 조회합니다.
    @GetMapping("/{recruitmentId}")
    public ResponseEntity getDetailRecruitment(@PathVariable long recruitmentId) {
        RecruitmentDetailResponseDto findDetailRecruitment = recruitmentService.findDetailRecruitment(recruitmentId);
        return new ResponseEntity<>(findDetailRecruitment, HttpStatus.OK);
    }

    //특정단어가 들어간 공고를 검색합니다.
    @GetMapping("/search")
    public ResponseEntity getRecruitmentByKeyword (@RequestParam String keyword){
        List<Recruitment> recruitments = recruitmentService.searchRecruitment(keyword);

        return new ResponseEntity<>(mapper.recruitmentToListResponseDto(recruitments), HttpStatus.OK);
    }


    //채용공고를 삭제합니다.
    @DeleteMapping("/{recruitmentId}")
    public ResponseEntity deleteRecruiyment (@PathVariable long recruitmentId) {
        recruitmentService.deleteRecruitment(recruitmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
