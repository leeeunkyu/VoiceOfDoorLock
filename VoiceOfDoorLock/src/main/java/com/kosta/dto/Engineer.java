package com.kosta.dto;

public class Engineer {
	private String engineerNum;
	private String engineerPhone;
	private String engineerName;
	private String branchName;
	private String isTrip;
	
	public Engineer() {
		super();
	}

	public Engineer(String engineerNum, String engineerPhone, String engineerName, String branchName, String isTrip) {
		super();
		this.engineerNum = engineerNum;
		this.engineerPhone = engineerPhone;
		this.engineerName = engineerName;
		this.branchName = branchName;
		this.isTrip = isTrip;
	}

	public String getEngineerNum() {
		return engineerNum;
	}

	public void setEngineerNum(String engineerNum) {
		this.engineerNum = engineerNum;
	}

	public String getEngineerPhone() {
		return engineerPhone;
	}

	public void setEngineerPhone(String engineerPhone) {
		this.engineerPhone = engineerPhone;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIsTrip() {
		return isTrip;
	}

	public void setIsTrip(String isTrip) {
		this.isTrip = isTrip;
	}
	

}
