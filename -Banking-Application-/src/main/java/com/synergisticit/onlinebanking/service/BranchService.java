package com.synergisticit.onlinebanking.service;

import com.synergisticit.onlinebanking.domain.Branch;

public interface BranchService {
	public void save(Branch branch);
	public boolean exists(int bcode );

}
