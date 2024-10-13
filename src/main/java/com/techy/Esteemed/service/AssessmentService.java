package com.techy.Esteemed.service;

import com.techy.Esteemed.model.Assessment;
import com.techy.Esteemed.model.Mentor;
import com.techy.Esteemed.model.Student;
import com.techy.Esteemed.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    public List<Assessment> getAssessmentsByMentor(Mentor mentor){
        return assessmentRepository.findByMentor(mentor);
    }

    public List<Assessment> getAssessmentsByStudent(Student student){
        return assessmentRepository.findByStudent(student);
    }

    public Assessment saveAssessment(Assessment assessment){
        return assessmentRepository.save(assessment);
    }

    // Additional assessment-related methods
}
