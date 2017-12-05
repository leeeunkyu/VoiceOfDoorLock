package com.kosta.service;

import java.util.ArrayList;
import java.util.Map;

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


	public String insertEngineer(String engineerPhone, String engineerName, String branchNaem, String isTrip) {
		return engineerDao.insertEngineer(engineerPhone,engineerName,branchNaem,isTrip);
	}


	public Engineer selectOneEngineer(String engineerPhone) {
		return engineerDao.selectOneEngineer(engineerPhone);
	}


	public boolean updateEngineer(String engineerNum,String engineerName, String engineerPhone, String isTrip) {

		return engineerDao.updateEngineer(engineerNum,engineerName,engineerPhone,isTrip);
	}


	public boolean deleteEngineer(String engineerNum) {
		// TODO Auto-generated method stub
		return engineerDao.deleteEngineer(engineerNum);
	}

}
