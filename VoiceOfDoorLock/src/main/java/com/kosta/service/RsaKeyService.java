package com.kosta.service;

import java.security.Key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.RsaKey;
import com.kosta.model.RsaKeyDao;

@Service
public class RsaKeyService {
	private RsaKeyDao rsaKeyDao;
	private static String ips;
	private static Key keySpec;

	@Autowired
	public void setRsaKeyDao(RsaKeyDao rsaKeyDao) {
		this.rsaKeyDao = rsaKeyDao;
	}
	
	public int insertRsaKey(RsaKey rsaKey) {
		return rsaKeyDao.insertRsaKey(rsaKey);
	}
	
	public int updateRsaKey(String getPrivateKeyModulus, RsaKey rsaKey) {
		return rsaKeyDao.updateRsaKey(getPrivateKeyModulus, rsaKey);
	}
	
	public RsaKey selectRsaKey() {
		
		return rsaKeyDao.selectRsaKey();
	}
}
