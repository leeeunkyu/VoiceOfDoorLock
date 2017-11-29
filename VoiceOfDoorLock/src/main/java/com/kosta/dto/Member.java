package com.kosta.dto;

public class Member {
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberAddress;
	private String memberEmail;
	private String notification;
	private String memberPublickey;
	private String lineId;
	private String block;
	
	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public Member() {
		super();
	}
	
	public Member(String memberId, String memberPw, String memberName, String memberPhone, String memberAddress,
			String memberEmail, String notification, String memberPublickey, String lineId, String block) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.memberEmail = memberEmail;
		this.notification = notification;
		this.memberPublickey = memberPublickey;
		this.lineId = lineId;
		this.block = block;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
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
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getMemberPublickey() {
		return memberPublickey;
	}
	public void setMemberPublickey(String memberPublickey) {
		this.memberPublickey = memberPublickey;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	
}
