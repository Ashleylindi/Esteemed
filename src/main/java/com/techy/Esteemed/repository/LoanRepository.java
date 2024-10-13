package com.techy.Esteemed.repository;

import com.techy.Esteemed.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}