package com.preliminary_task.preliminary_task.recruitment.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecruitmentDetailResponseDto {
    private long recruitmentId;
    private String companyName;
    private String nation;
    private String region;
    private String position;
    private int compensation;
    private String content;
    private String technology;
    private List<Long> otherRecruitments;

}
