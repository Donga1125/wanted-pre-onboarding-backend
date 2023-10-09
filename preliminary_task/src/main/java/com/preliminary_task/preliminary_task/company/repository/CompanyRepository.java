package com.preliminary_task.preliminary_task.company.repository;

import com.preliminary_task.preliminary_task.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
