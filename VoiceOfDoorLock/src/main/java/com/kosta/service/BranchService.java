package com.kosta.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.Branch;
import com.kosta.model.BranchDao;

@Service
public class BranchService {
	BranchDao branchDao;
	
	@Autowired
	public void setBranchDao(BranchDao branchDao) {
		this.branchDao = branchDao;
	}

	public Branch branchSelect(String branchName) {
		return branchDao.branchSelect(branchName);
	}

	public void insertBranch(Branch branch) {
		branchDao.insertBranch(branch);
	}

}
