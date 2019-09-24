package com.synergisticit.onlinebanking.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.synergisticit.onlinebanking.domain.Branch;
public interface BranchRepository extends JpaRepository<Branch,Integer> {

}
