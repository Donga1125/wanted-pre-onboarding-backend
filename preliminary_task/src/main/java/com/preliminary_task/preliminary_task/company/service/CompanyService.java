package com.preliminary_task.preliminary_task.company.service;

import com.preliminary_task.preliminary_task.company.entity.Company;
import com.preliminary_task.preliminary_task.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    //회사를 등록합니다.
    public Company createCompany(Company company){
        return companyRepository.save(company);
    }

    //특정 회사를 조회합니다.
    public Company findCompany(long companyId){
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        Company findCompany = optionalCompany.orElseThrow(() -> new RuntimeException("COMPANY_NOT_FOUND")) ;
        return findCompany;
    }

}
