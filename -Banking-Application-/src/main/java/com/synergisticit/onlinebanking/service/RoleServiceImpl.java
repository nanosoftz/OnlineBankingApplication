package com.synergisticit.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.onlinebanking.domain.Role;
import com.synergisticit.onlinebanking.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	@Override
	public void save(Role role) {
		roleRepository.save(role);
		}
	@Override
	public boolean exists(long id) {
		return roleRepository.existsById(id);
	}

}
