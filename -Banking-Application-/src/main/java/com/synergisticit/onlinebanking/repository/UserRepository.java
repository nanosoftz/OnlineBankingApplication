package com.synergisticit.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.onlinebanking.domain.User;


public interface UserRepository extends JpaRepository<User,Long>{

	public User findByUsername(String username);
	
}
