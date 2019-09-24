package com.synergisticit.onlinebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.onlinebanking.domain.Branch;
import com.synergisticit.onlinebanking.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	 BranchRepository branchrepository;

	@Override
	public void save(Branch branch) {
		branchrepository.save(branch);
		
	}

@Override
	public boolean exists(int bcode) {
		return branchrepository.existsById(bcode);
	}

}
