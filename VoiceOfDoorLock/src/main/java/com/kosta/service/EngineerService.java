package com.kosta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.Engineer;
import com.kosta.model.EngineerDao;

@Service
public class EngineerService {

	private EngineerDao engineerDao;
	
	@Autowired
	public void setEngineerDao(EngineerDao engineerDao) {
		this.engineerDao = engineerDao;
	}


	public ArrayList<Engineer> engineerSelectList(String searchContent, String selectContent, String branchNaem) {
		return engineerDao.engineerSelectList(searchContent,selectContent,branchNaem);
	}


	public void insertEngineer(String engineerPhone, String engineerName, String branchNaem, String engineerTrip) {
		engineerDao.insertEngineer(engineerPhone,engineerName,branchNaem,engineerTrip);
	}

}
