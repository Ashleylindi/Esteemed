package com.techy.Esteemed.controller;

import com.techy.Esteemed.model.Mentor;
import com.techy.Esteemed.model.Student;
import com.techy.Esteemed.service.MentorService;
import com.techy.Esteemed.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model){
        model.addAttribute("pendingMentors", mentorService.getPendingMentors());
        model.addAttribute("students", studentService.getAllStudents());
        return "admin-dashboard";
    }

    @PostMapping("/approveMentor")
    public String approveMentor(@RequestParam Long mentorId){
        mentorService.approveMentor(mentorId);
        return "redirect:/admin/dashboard";
    }

    // Additional endpoints for adding/removing mentors and students
}
