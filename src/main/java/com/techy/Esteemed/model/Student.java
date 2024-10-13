package com.techy.Esteemed.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Student extends User {

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Assessment> assessments;

    @ManyToMany
    private List<Loan> loans;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<SkillProgress> skillProgress;

    // Additional student-specific fields can be added here
}

