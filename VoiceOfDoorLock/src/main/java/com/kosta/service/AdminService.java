package com.kosta.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.Admin;
import com.kosta.model.AdminDao;

@Service
public class AdminService {

	private AdminDao adminDao;
	
	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public boolean confirmBranch(String branchName, String branchCode) {
		return adminDao.isBranch(branchName,branchCode);
	}

	public boolean addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	public Map<String,String> selectAdmin(String adminId, String adminPw) {
		return adminDao.selectAdmin(adminId,adminPw);
	}

	public boolean isId(String adminId) {
		return adminDao.isId(adminId);
	}
	
}