package com.preliminary_task.preliminary_task.company.dto;

import com.preliminary_task.preliminary_task.recruitment.entity.Recruitment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CompanyResponseDto {

    private long companyId;
    private String companyName;
    private List<Recruitment> recruitments = new ArrayList<>();
}
