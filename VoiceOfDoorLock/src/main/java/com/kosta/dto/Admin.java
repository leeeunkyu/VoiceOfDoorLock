package com.kosta.dto;

public class Admin {
	
	private String adminId;
	private String adminPw;
	private String adminEmail;
	private String adminName;
	private String adminGrade;
	private String branchName;

	
	public Admin() {
	}
	
	public Admin(String adminId, String adminPw, String adminEmail, String adminName, String adminGrade,
			String branchName) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminEmail = adminEmail;
		this.adminName = adminName;
		this.adminGrade = adminGrade;
		this.branchName = branchName;
	}

	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public String getAdminPw() {
		return adminPw;
	}


	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}


	public String getAdminEmail() {
		return adminEmail;
	}


	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminGrade() {
		return adminGrade;
	}


	public void setAdminGrade(String adminGrade) {
		this.adminGrade = adminGrade;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [adminId=");
		builder.append(adminId);
		builder.append(", adminPw=");
		builder.append(adminPw);
		builder.append(", adminEmail=");
		builder.append(adminEmail);
		builder.append(", adminName=");
		builder.append(adminName);
		builder.append(", adminGrade=");
		builder.append(adminGrade);
		builder.append(", branchName=");
		builder.append(branchName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
