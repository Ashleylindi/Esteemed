package com.techy.Esteemed.controller;

import com.techy.Esteemed.model.Assessment;
import com.techy.Esteemed.model.Student;
import com.techy.Esteemed.service.AssessmentService;
import com.techy.Esteemed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String studentDashboard(Model model, Authentication authentication){
        String email = authentication.getName();
        Student student = (Student) userService.findByEmail(email).orElseThrow(() -> new RuntimeException("Student not found"));
        model.addAttribute("assessments", assessmentService.getAssessmentsByStudent(student));
        return "student-dashboard";
    }

    @GetMapping("/submitAssessment")
    public String showSubmitAssessmentForm(Model model){
        model.addAttribute("assessment", new Assessment());
        return "submit-assessment";
    }

    @PostMapping("/submitAssessment")
    public String submitAssessment(@ModelAttribute Assessment assessment, Authentication authentication){
        String email = authentication.getName();
        Student student = (Student) userService.findByEmail(email).orElseThrow(() -> new RuntimeException("Student not found"));
        assessment.setStudent(student);
        assessmentService.saveAssessment(assessment);
        return "redirect:/student/dashboard";
    }

    // Additional endpoints for accessing materials, applying for mentorship, viewing grades, etc.
}
