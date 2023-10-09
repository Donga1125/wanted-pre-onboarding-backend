package com.preliminary_task.preliminary_task.recruitment.service;


import com.preliminary_task.preliminary_task.recruitment.entity.Recruitment;
import com.preliminary_task.preliminary_task.recruitment.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Recruitment findRecruitment = findRecruitment(recruitment.getRecruitmentId());
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

    //공고를 불러옵니다.

    //공고를 삭제합니다.


    //recruitmentId를 통해 공고를 찾습니다.
    public Recruitment findRecruitment(long recruitmentId){
        return recruitmentRepository.findById(recruitmentId)
                .orElseThrow(() -> new RuntimeException("RECRUITMENT_NOT_FOUND"));
    }
}
