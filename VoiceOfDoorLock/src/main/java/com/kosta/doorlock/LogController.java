package com.kosta.doorlock;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.Log;
import com.kosta.service.LogService;

@Controller
public class LogController {
	
	private LogService logService;

	@Autowired
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
	@RequestMapping(value="logListView.do")
	public ModelAndView logListView() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Log> logArr = logService.logSelectList(null,null);
		mv.addObject("logListSize", ""+logArr.size());
		mv.setViewName("log/loglist");
		return mv;
	}
	
	@RequestMapping(value="logSelectSize.do")
	@ResponseBody
	public int memberSelectSize(String searchContent,String selectContent) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Log> logArr = logService.logSelectList(searchContent,selectContent);
		int length = logArr.size();
		System.out.println("길이 초기화: "+length);
		return length;
	}	
	
	@RequestMapping(value="logSelectList.do")
	@ResponseBody
	public ArrayList<Log> logSelectList(int index,String searchContent,String selectContent) {

		ArrayList<Log> logArr = logService.logSelectList(searchContent,selectContent);
		ArrayList<Log> logList = new ArrayList<Log>();
		if(logArr.size() >= index*5) {
			for(int i=(index-1)*5;i<index*5;i++ ) {
				logList.add(logArr.get(i));
			}
		}else {
			for(int i=(index-1)*5;i<logArr.size();i++ ) {
				logList.add(logArr.get(i));
			}
		}
		return logList;
	}
	
}
