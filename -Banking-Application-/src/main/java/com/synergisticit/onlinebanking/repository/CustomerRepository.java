package com.synergisticit.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.onlinebanking.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
