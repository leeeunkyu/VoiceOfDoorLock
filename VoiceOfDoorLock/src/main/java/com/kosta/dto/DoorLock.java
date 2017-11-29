package com.kosta.dto;

public class DoorLock {
	
	private String doorLockNum;
	private String doorLockPassword;
	
	public DoorLock() {
		super();
	}
	
	public DoorLock(String doorLockNum, String doorLockPassword) {
		super();
		this.doorLockNum = doorLockNum;
		this.doorLockPassword = doorLockPassword;
	}
	
	public String getDoorLockNum() {
		return doorLockNum;
	}
	public void setDoorLockNum(String doorLockNum) {
		this.doorLockNum = doorLockNum;
	}
	public String getDoorLockPassword() {
		return doorLockPassword;
	}
	public void setDoorLockPassword(String doorLockPassword) {
		this.doorLockPassword = doorLockPassword;
	}
	
}
