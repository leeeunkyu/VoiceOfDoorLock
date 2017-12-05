package com.kosta.dto;

public class BlockCountByAdmin {
	private String memberId;
	private String adminId;
	private String blockReason;
	private String blockDay;
	
	public BlockCountByAdmin() {
		super();
	}
	
	public BlockCountByAdmin(String memberId, String adminId, String blockReason, String blockDay) {
		super();
		this.memberId = memberId;
		this.adminId = adminId;
		this.blockReason = blockReason;
		this.blockDay = blockDay;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getBlockReason() {
		return blockReason;
	}
	public void setBlockReason(String blockReason) {
		this.blockReason = blockReason;
	}
	public String getBlockDay() {
		return blockDay;
	}
	public void setBlockDay(String blockDay) {
		this.blockDay = blockDay;
	}

}
