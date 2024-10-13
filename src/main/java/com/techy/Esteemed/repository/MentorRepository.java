package com.techy.Esteemed.repository;

import com.techy.Esteemed.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor, Long> {
    List<Mentor> findByAccepted(boolean accepted);
}
