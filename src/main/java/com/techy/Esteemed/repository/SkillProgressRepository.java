package com.techy.Esteemed.repository;

import com.techy.Esteemed.model.SkillProgress;
import com.techy.Esteemed.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillProgressRepository extends JpaRepository<SkillProgress, Long> {
    List<SkillProgress> findByStudent(Student student);
}
