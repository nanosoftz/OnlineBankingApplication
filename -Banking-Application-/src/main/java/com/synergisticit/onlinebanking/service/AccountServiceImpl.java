package com.synergisticit.onlinebanking.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.onlinebanking.domain.Account;

import com.synergisticit.onlinebanking.domain.Transaction;
import com.synergisticit.onlinebanking.repository.AccountRepository;
import com.synergisticit.onlinebanking.repository.CustomerRepository;
import com.synergisticit.onlinebanking.repository.TransactionRepository;

@Service//(value="accountServiceImpl")
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public void save(Account acc) {
		accountRepository.save(acc);
		Transaction tx=new Transaction();
		tx.setComments("creating account");
		tx.setAmounttx(acc.getAccBalance());
		tx.setFromAccount(acc.getAccno());
		tx.setTxdate(acc.getOpendate());
		transactionRepository.save(tx);
		}
	
////
	@Override
	public boolean exists(long accno) {
		
		return accountRepository.existsById(accno);
	}
	@Override
	public void updateById(long accno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long accno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getById(long accno) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return null;
	}
}
