package com.techy.Esteemed.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Mentor extends User {
    private boolean accepted;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    private List<Assessment> assessments;

    // Additional mentor-specific fields can be added here
}
