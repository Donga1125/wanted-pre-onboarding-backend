package com.preliminary_task.preliminary_task.recruitment.service;

import com.preliminary_task.preliminary_task.company.entity.Company;
import com.preliminary_task.preliminary_task.recruitment.dto.RecruitmentDetailResponseDto;
import com.preliminary_task.preliminary_task.recruitment.entity.Recruitment;
import com.preliminary_task.preliminary_task.recruitment.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruitmentService {
    private final RecruitmentRepository recruitmentRepository;

    //공고를 등록합니다.
    public Recruitment createRecruitment (Recruitment recruitment){

        return recruitmentRepository.save(recruitment);
    }

    //공고를 수정합니다.
    public Recruitment updateRecruitment(Recruitment recruitment){
        Recruitment findRecruitment = findRecruitmentById(recruitment.getRecruitmentId());
        Optional.ofNullable(recruitment.getTechnology())
                .ifPresent(technology -> findRecruitment.setTechnology(technology));
        Optional.ofNullable(recruitment.getCompensation())
                .ifPresent(compensation -> findRecruitment.setCompensation(compensation));
        Optional.ofNullable(recruitment.getPosition())
                .ifPresent(position -> findRecruitment.setPosition(position));
        Optional.ofNullable(recruitment.getContent())
                .ifPresent(content -> findRecruitment.setContent(content));

        Recruitment update = recruitmentRepository.save(findRecruitment);
        return update;
    }

    //채용공고를 목록을 불러옵니다.
    public List<Recruitment> findAllRecruitment (){
        List<Recruitment> recruitments = recruitmentRepository.findAll();
        return recruitments;
    }

    //특정 채용공고의 상세내용을 불러옵니다.
    public RecruitmentDetailResponseDto findDetailRecruitment(long recruitmentId ){
        Recruitment findRecruitment = findRecruitmentById(recruitmentId);
        List<Long> otherRecruitments = getRecruitmentByCompanyId(findRecruitment.getCompanyId());

        RecruitmentDetailResponseDto responseDto = new RecruitmentDetailResponseDto();
        responseDto.setRecruitmentId(findRecruitment.getRecruitmentId());
        responseDto.setCompanyName(findRecruitment.getCompany().getCompanyName());
        responseDto.setNation(findRecruitment.getCompany().getNation());
        responseDto.setRegion(findRecruitment.getCompany().getRegion());
        responseDto.setPosition(findRecruitment.getPosition());
        responseDto.setCompensation(findRecruitment.getCompensation());
        responseDto.setContent(findRecruitment.getContent());
        responseDto.setTechnology(findRecruitment.getTechnology());
        responseDto.setOtherRecruitments(otherRecruitments);
        return responseDto;
    }

    //채용공고를 검색합니다.
    public List<Recruitment> searchRecruitment (String keyword){
        return recruitmentRepository.findByPositionContainingOrContentContainingOrTechnologyContaining(keyword, keyword,keyword);
    }


    //공고를 삭제합니다.
    public void deleteRecruitment (long recruitmentId){
        recruitmentRepository.deleteById(recruitmentId);
    }


    //recruitmentId를 통해 공고를 찾습니다.
    public Recruitment findRecruitmentById(long recruitmentId){
        return recruitmentRepository.findById(recruitmentId)
                .orElseThrow(() -> new RuntimeException("RECRUITMENT_NOT_FOUND"));
    }

    //회사가 작성한 다른 공고의 ID를 찾습니다.
    public List<Long> getRecruitmentByCompanyId(Long companyId) {
        List<Recruitment> recruitments = recruitmentRepository.findByCompanyId(companyId);
        List<Long> recruitmentIds = recruitments.stream()
                .map(Recruitment::getRecruitmentId)
                .collect(Collectors.toList());
        return recruitmentIds;
    }
}
