package com.synergisticit.onlinebanking.service;


import com.synergisticit.onlinebanking.domain.Account;
import com.synergisticit.onlinebanking.domain.Transaction;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.onlinebanking.repository.AccountRepository;
import com.synergisticit.onlinebanking.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService  {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
		}
	
	//----------------TRANSFER AMOUNT__________________//
	@Override
	public Transaction transferamount(double amounttx, long fromAccount, long toAccount) {
		Optional <Account> opFromAcct=accountRepository.findById(fromAccount);
		Account fromtransferAccount= opFromAcct.get();
		fromtransferAccount.setAccBalance(fromtransferAccount.getAccBalance()-amounttx);
		accountRepository.save(fromtransferAccount);
		
		
		Optional <Account> opToAcct=accountRepository.findById(toAccount);
		Account totransferAccount= opToAcct.get();
		totransferAccount.setAccBalance(totransferAccount.getAccBalance()+amounttx);
		accountRepository.save(totransferAccount);
		
		Transaction tx=new Transaction();
		tx.setFromAccount(fromtransferAccount.getAccno());
		tx.setToAccount(totransferAccount.getAccno());
		tx.setComments(fromtransferAccount.getAccno()+", "+totransferAccount.getAccno()+","+amounttx+","+"amount transfer");
		tx.setTxdate(new Date(System.currentTimeMillis()));
		tx.setAmounttx(fromtransferAccount.getAccBalance());
		
		transactionRepository.save(tx);
		return tx;
	
	}

	//_____________________DEPOSIT AMOUNT________________________//
	@Override
	public Transaction deposit(double depositamt, long fromAccount, long toAccount) {
		Optional<Account> opAcc= accountRepository.findById(toAccount);
		Account toDepositaccount=opAcc.get();
		toDepositaccount.setAccBalance(toDepositaccount.getAccBalance()+depositamt);
		accountRepository.save(toDepositaccount);
		
		
		Transaction tx=new Transaction();
		tx.setFromAccount(toAccount);
		tx.setToAccount(toDepositaccount.getAccno());
		tx.setTxdate(new Date(System.currentTimeMillis()));
		tx.setComments(toDepositaccount.getAccno()+","+depositamt+"amount deposit");
		tx.setDepositamt(depositamt);
		
		transactionRepository.save(tx);
		return tx;
	}

	
	
	//____________________WITHDRAW AMOUNT-_____________________//
	@Override
	public Transaction withdraw(double withdrawamt, long fromAccount, long toAccount) {
		Optional <Account> opWithdraw=accountRepository.findById(fromAccount);
		Account fromwithdraw=opWithdraw.get();
	
		fromwithdraw.setAccBalance(fromwithdraw.getAccBalance()-withdrawamt);
		accountRepository.save(fromwithdraw);
		
		Transaction tx=new Transaction();
		tx.setFromAccount(fromAccount);
		tx.setToAccount(fromwithdraw.getAccno());
		tx.setTxdate(new Date(System.currentTimeMillis()));
		tx.setComments("withdraw amount");
		tx.setWithdrawamt(withdrawamt);
		transactionRepository.save(tx);
		return tx;
	}
}
