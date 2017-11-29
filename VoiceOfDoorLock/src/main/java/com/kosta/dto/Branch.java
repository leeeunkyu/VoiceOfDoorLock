package com.kosta.dto;

public class Branch {
	private String branchName;
	private String branchCode;
	private String branchLatitude;
	private String branchLongitude;
	
	public Branch(String branchName, String branchCode, String branchLatitude, String branchLongitude) {
		super();
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.branchLatitude = branchLatitude;
		this.branchLongitude = branchLongitude;
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

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
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
	
	

}
