package com.preliminary_task.preliminary_task.recruitment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class RecruitmentPatchDto {

    private long recruitmentId;

    private String position;

    private int compensation;

    private String content;

    private String technology;
}
