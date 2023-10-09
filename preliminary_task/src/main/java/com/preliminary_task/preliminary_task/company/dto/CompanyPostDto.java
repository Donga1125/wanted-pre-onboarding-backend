package com.preliminary_task.preliminary_task.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyPostDto {

    private long companyId;
    private String companyName;
    private String nation;
    private String region;
}
