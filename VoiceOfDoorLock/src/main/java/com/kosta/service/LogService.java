package com.kosta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.Log;
import com.kosta.model.LogDao;

@Service
public class LogService {

	private LogDao logDao;

	@Autowired
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}


	public ArrayList<Log> logSelectList(String searchContent, String selectContent) {
		return logDao.logSelectList(searchContent,selectContent);
	}

}
