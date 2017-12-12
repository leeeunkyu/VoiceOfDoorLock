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

	public String selectAdminId(String adminName, String branchName, String branchNum) {
		return adminDao.selectAdminId(adminName,branchName,branchNum);
	}

	public boolean selectAdminPw(String adminId, String branchName, String branchNum) {
		return adminDao.selectAdminPw(adminId,branchName,branchNum);
	}

	public boolean updateAdminPw(String adminId, String adminPw) {
		return adminDao.updateAdminPw(adminId,adminPw);
	}

	public String selectAdminEmail(String adminId) {
		return adminDao.selectAdminEmail(adminId);
	}

	public Admin selectAdminOne(String adminId) {
		return adminDao.selectAdminOne(adminId);
	}
	
}
