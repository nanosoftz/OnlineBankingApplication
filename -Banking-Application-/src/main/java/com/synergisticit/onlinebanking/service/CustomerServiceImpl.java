package com.synergisticit.onlinebanking.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.synergisticit.onlinebanking.domain.Customer;

import com.synergisticit.onlinebanking.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public void save(Customer customer) {
		System.out.println("customer created");
		customerRepository.save(customer);
		
	}


	@Override
	public Customer findById(int customerid) {
		Optional<Customer>opCustomer=customerRepository.findById(customerid);
		Customer customer=opCustomer.orElseThrow(RuntimeException::new);
		return customer;
	}


	@Override
	public boolean existsById(int customerid) {
		// TODO Auto-generated method stub
		return customerRepository.existsById(customerid);
	}





}

	