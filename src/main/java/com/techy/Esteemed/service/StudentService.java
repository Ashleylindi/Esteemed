package com.techy.Esteemed.service;

import com.techy.Esteemed.model.Student;
import com.techy.Esteemed.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // Additional student-related methods
}
