package com.preliminary_task.preliminary_task.recruitment.dto;

import com.preliminary_task.preliminary_task.company.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;



@Getter
@Setter
@NoArgsConstructor
public class RecruitmentPostDto {

    private long companyId;
    //@NotBlank(message = "position은 공백이 아니어야 합니다.")
    private String position;
    //@NotBlank(message = "position은 공백이 아니어야 합니다.")
    private int compensation;
    //@NotBlank(message = "compensation은 공백이 아니어야 합니다.")
    private String content;
    //@NotBlank(message = "technology은 공백이 아니어야 합니다.")
    private String technology;


}
