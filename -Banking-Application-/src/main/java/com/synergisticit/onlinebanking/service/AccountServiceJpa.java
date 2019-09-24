package com.synergisticit.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.synergisticit.onlinebanking.domain.Account;
import com.synergisticit.onlinebanking.repository.AccountRepository;

@Service(value="accountServiceJpa")
public class AccountServiceJpa implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void save(Account acc) {
		System.out.println("using service jpa to save details");
		accountRepository.save(acc);
	}
	

	@Override
	public List<Account> findAllAccount() {
		System.out.println("list all account holders from JPA respository");
		
		return accountRepository.findAll(new Sort(Direction.ASC,"accno"));

	}
	
	@Override
	public void updateById(long accno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long accno) {
		// TODO Auto-generated method stub
		 accountRepository.deleteById(accno);
		
	}

	@Override
	public Account getById(long accno) {
		// TODO Auto-generated method stub
		return accountRepository.getOne(accno);
	}

	

	@Override
	public boolean exists(long accno) {
		// TODO Auto-generated method stub
		return false;
	}


	


}
