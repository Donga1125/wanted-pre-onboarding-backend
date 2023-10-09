package com.preliminary_task.preliminary_task.recruitment.repository;

import com.preliminary_task.preliminary_task.company.entity.Company;
import com.preliminary_task.preliminary_task.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {
    List<Recruitment> findByCompanyId (Long companyId);

    //공고 검색
    List<Recruitment> findByPositionContainingOrContentContainingOrTechnologyContaining(String keyword1,String keyword2, String keyword3);

}
