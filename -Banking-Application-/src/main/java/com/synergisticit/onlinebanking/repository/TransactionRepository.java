package com.synergisticit.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.onlinebanking.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {



}
