package com.techy.Esteemed.controller;

import com.techy.Esteemed.model.Assessment;
import com.techy.Esteemed.model.Mentor;
import com.techy.Esteemed.repository.UserRepository;
import com.techy.Esteemed.service.AssessmentService;
import com.techy.Esteemed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String mentorDashboard(Model model, Authentication authentication){
        String email = authentication.getName();
        Mentor mentor = (Mentor) userService.findByEmail(email).orElseThrow(() -> new RuntimeException("Mentor not found"));
        model.addAttribute("assessments", assessmentService.getAssessmentsByMentor(mentor));
        return "mentor-dashboard";
    }

    @GetMapping("/addAssessment")
    public String showAddAssessmentForm(Model model){
        model.addAttribute("assessment", new Assessment());
        return "add-assessment";
    }

    @PostMapping("/addAssessment")
    public String addAssessment(@ModelAttribute Assessment assessment, Authentication authentication){
        String email = authentication.getName();
        Mentor mentor = (Mentor) userService.findByEmail(email).orElseThrow(() -> new RuntimeException("Mentor not found"));
        assessment.setMentor(mentor);
        assessmentService.saveAssessment(assessment);
        return "redirect:/mentor/dashboard";
    }

    // Additional endpoints for grading assessments, managing mentorship, etc.
}
