package com.techy.Esteemed.service;

import com.techy.Esteemed.model.Mentor;
import com.techy.Esteemed.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public List<Mentor> getPendingMentors(){
        return mentorRepository.findByAccepted(false);
    }

    public Mentor approveMentor(Long mentorId){
        Mentor mentor = mentorRepository.findById(mentorId)
                .orElseThrow(() -> new RuntimeException("Mentor not found"));
        mentor.setAccepted(true);
        return mentorRepository.save(mentor);
    }

    // Additional mentor-related methods
}
