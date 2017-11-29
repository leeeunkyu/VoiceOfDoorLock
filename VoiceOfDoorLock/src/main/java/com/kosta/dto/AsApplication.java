package com.kosta.dto;

public class AsApplication {
	private String applicationIndex;
	private String memberId;
	private String memberName;
	private String memberPhone;
	private String memberAddress;
	private String doorlockNum;
	private String branchName;
	private String applicationDay;
	
	public AsApplication() {
		super();
	}

	public AsApplication(String applicationIndex, String memberId, String memberName, String memberPhone,
			String memberAddress, String doorlockNum, String branchName, String applicationDay) {
		super();
		this.applicationIndex = applicationIndex;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.doorlockNum = doorlockNum;
		this.branchName = branchName;
		this.applicationDay = applicationDay;
	}
	
	public String getApplicationIndex() {
		return applicationIndex;
	}
	public void setApplicationIndex(String applicationIndex) {
		this.applicationIndex = applicationIndex;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getDoorlockNum() {
		return doorlockNum;
	}
	public void setDoorlockNum(String doorlockNum) {
		this.doorlockNum = doorlockNum;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getApplicationDay() {
		return applicationDay;
	}
	public void setApplicationDay(String applicationDay) {
		this.applicationDay = applicationDay;
	}

}
