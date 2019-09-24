package com.synergisticit.onlinebanking.service;

import com.synergisticit.onlinebanking.domain.User;

public interface UserService {
	public void save(User user);

	public User findByUsername(String username);
}
