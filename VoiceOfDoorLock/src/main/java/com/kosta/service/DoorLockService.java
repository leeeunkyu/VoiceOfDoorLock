package com.kosta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.model.DoorLockDao;

@Service
public class DoorLockService {

	private DoorLockDao doorLockDao;
	
	@Autowired
	public void setDoorLockDao(DoorLockDao doorLockDao) {
		this.doorLockDao = doorLockDao;
	}

	public boolean isDoorLockPassword(String doorLockNum) {
		return doorLockDao.isDoorLockPassword(doorLockNum);
	}

	public boolean insertDoorLock(String doorLockNum, String doorLockPassword) {
		return doorLockDao.insertDoorLock(doorLockNum,doorLockPassword);
	}

}
