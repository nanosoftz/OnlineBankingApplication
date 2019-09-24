package com.synergisticit.onlinebanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.synergisticit.onlinebanking.domain.Customer;
import com.synergisticit.onlinebanking.domain.Loan;
import com.synergisticit.onlinebanking.repository.CustomerRepository;
import com.synergisticit.onlinebanking.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void save(Loan loan) {
		loanRepository.save(loan);
		}

/*	@Override
	public List<Loan> findAll(int loanid) {
		System.out.println("list of loans get by one customer");
		List<Loan> loanList=loanRepository.findAll();
		for(Loan loan:loanList){
			System.out.println(loan.getLoanid()+","+loan.getLoanType()+","+loan.getAmount());
		}
		System.out.println("loanList"+loanList);
		return loanRepository.findAll();
	}

*/
	

}
