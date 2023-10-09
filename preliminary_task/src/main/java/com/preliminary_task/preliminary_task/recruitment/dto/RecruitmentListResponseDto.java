package com.preliminary_task.preliminary_task.recruitment.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RecruitmentListResponseDto {
    private long recruitmentId;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private String technology;
    private int compensation;

}
