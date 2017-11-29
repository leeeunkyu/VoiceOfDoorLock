package com.kosta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.AsApplication;
import com.kosta.model.AsApplicationDao;

@Service
public class AsApplicationService {

	AsApplicationDao asApplicationDao;
	
	@Autowired
	public void setAsApplicationDao(AsApplicationDao asApplicationDao) {
		this.asApplicationDao = asApplicationDao;
	}


	public ArrayList<AsApplication> asApplicationSelectList(String searchContent, String selectContent) {
		return asApplicationDao.asApplicationSelectList(searchContent,selectContent);
	}

}
