package com.synergisticit.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.onlinebanking.domain.Loan;

public interface LoanRepository extends JpaRepository<Loan,Integer> {

	

}
