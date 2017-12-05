package com.kosta.dto;

public class Branch {
	private String branchName;
	private String branchNum;
	private String branchLatitude;
	private String branchLongitude;
	private String branchPhone;
	private String branchEmail;
	
	public Branch(String branchName, String branchNum, String branchLatitude, String branchLongitude,
			String branchPhone, String branchEmail) {
		super();
		this.branchName = branchName;
		this.branchNum = branchNum;
		this.branchLatitude = branchLatitude;
		this.branchLongitude = branchLongitude;
		this.branchPhone = branchPhone;
		this.branchEmail = branchEmail;
	}

	public Branch() {
		super();
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchNum() {
		return branchNum;
	}

	public void setBranchNum(String branchNum) {
		this.branchNum = branchNum;
	}

	public String getBranchLatitude() {
		return branchLatitude;
	}

	public void setBranchLatitude(String branchLatitude) {
		this.branchLatitude = branchLatitude;
	}

	public String getBranchLongitude() {
		return branchLongitude;
	}

	public void setBranchLongitude(String branchLongitude) {
		this.branchLongitude = branchLongitude;
	}

	public String getBranchPhone() {
		return branchPhone;
	}

	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	public String getBranchEmail() {
		return branchEmail;
	}

	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}
	
	
	
	
	
	
}
