package com.synergisticit.onlinebanking.service;

import com.synergisticit.onlinebanking.domain.Role;

public interface RoleService {
	public void save(Role role);
	public boolean exists(long id);
}
