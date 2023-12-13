package com.example.onthi_1.models;

import com.example.onthi_1.enums.ExperienceRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="experience")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "role")
    private ExperienceRole role;

    @Column(name = "company",length = 120)
    private String company;

    @Column(name = "work_desc",length = 400)
    private String work_desc;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
