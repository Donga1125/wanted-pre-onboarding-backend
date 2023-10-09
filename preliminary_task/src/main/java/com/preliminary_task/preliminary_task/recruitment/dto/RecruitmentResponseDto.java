package com.preliminary_task.preliminary_task.recruitment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RecruitmentResponseDto {
    private long recruitmentId;
    private long companyId;
    private String position;
    private int compensation;
    private String content;
    private String technology;
    private LocalDateTime createdAt;
}
