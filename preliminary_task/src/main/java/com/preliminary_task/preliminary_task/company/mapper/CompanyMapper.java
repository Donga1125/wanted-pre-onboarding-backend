package com.preliminary_task.preliminary_task.company.mapper;

import com.preliminary_task.preliminary_task.company.dto.CompanyPostDto;
import com.preliminary_task.preliminary_task.company.dto.CompanyResponseDto;
import com.preliminary_task.preliminary_task.company.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company postDtoToCompany (CompanyPostDto postDto);

    CompanyResponseDto companyToResponseDto (Company company);
}
