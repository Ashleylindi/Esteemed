package com.techy.Esteemed.repository;

import com.techy.Esteemed.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
