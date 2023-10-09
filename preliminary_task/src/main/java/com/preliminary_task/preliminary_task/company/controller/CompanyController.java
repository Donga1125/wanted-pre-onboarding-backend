package com.preliminary_task.preliminary_task.company.controller;

import com.preliminary_task.preliminary_task.company.dto.CompanyPostDto;
import com.preliminary_task.preliminary_task.company.entity.Company;
import com.preliminary_task.preliminary_task.company.mapper.CompanyMapper;
import com.preliminary_task.preliminary_task.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/companys")
public class CompanyController {

    private final CompanyMapper mapper;
    private final CompanyService companyService;

    //회사를 등록합니다.
    @PostMapping("/new-company")
    public ResponseEntity postCompany(@RequestBody CompanyPostDto postDto){
        Company company = mapper.postDtoToCompany(postDto);
        Company createCompany =companyService.createCompany(company);
        return new ResponseEntity<>(createCompany, HttpStatus.CREATED);
    }

    //특정 회사를 조회합니다.
    @GetMapping("/{companyId}")
    public ResponseEntity getCompany (@PathVariable long companyId){
        Company findCompany = companyService.findCompany(companyId);
        return new ResponseEntity<>(mapper.companyToResponseDto(findCompany), HttpStatus.OK);
    }
}
