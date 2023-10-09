package com.preliminary_task.preliminary_task.recruitment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.preliminary_task.preliminary_task.company.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recruitmentId;

    @Column(nullable = false)
    private long companyId;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private int compensation;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String technology;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "COMPANY_ID")
    private Company company;
}
