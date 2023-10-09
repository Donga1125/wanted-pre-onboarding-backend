package com.preliminary_task.preliminary_task.company.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.preliminary_task.preliminary_task.recruitment.entity.Recruitment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String nation;

    @Column(nullable = false)
    private String region;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Recruitment> recruitments = new ArrayList<>();
}
