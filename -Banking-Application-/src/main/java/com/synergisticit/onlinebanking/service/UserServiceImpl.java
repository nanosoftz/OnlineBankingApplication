package com.synergisticit.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synergisticit.onlinebanking.domain.User;
import com.synergisticit.onlinebanking.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		System.out.println("user from service @@@@"+user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); //LINE 21 DOING DECRYPING PASSWORD
		userRepository.save(user);
		System.out.println();
	}
	@Override
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
		
	}
	
	

}
