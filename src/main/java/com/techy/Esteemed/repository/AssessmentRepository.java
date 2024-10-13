package com.techy.Esteemed.repository;

import com.techy.Esteemed.model.Assessment;
import com.techy.Esteemed.model.Mentor;
import com.techy.Esteemed.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    List<Assessment> findByMentor(Mentor mentor);
    List<Assessment> findByStudent(Student student);
}
