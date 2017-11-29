package com.kosta.doorlock;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.AsApplication;
import com.kosta.service.AsApplicationService;

@Controller
public class AsApplicationController {
	
	AsApplicationService asApplicationService;
	
	@Autowired
	public void setAsApplicationService(AsApplicationService asApplicationService) {
		this.asApplicationService = asApplicationService;
	}
	
	@RequestMapping(value="asApplicationListView.do")
	public ModelAndView memberListView() {
		ModelAndView mv = new ModelAndView();
		ArrayList<AsApplication> asApplicationArr = asApplicationService.asApplicationSelectList(null,null);
		mv.addObject("asApplicationListSize", ""+asApplicationArr.size());
		mv.setViewName("asApplication/asApplicationlist");
		return mv;
	}
	@RequestMapping(value="asApplicationSelectSize.do")
	@ResponseBody
	public int memberSelectSize(String searchContent,String selectContent) {
		ArrayList<AsApplication> asApplicatioArr = asApplicationService.asApplicationSelectList(searchContent,selectContent);
		int length = asApplicatioArr.size();
		System.out.println("길이 초기화: "+length);
		return length;
	}
	
	@RequestMapping(value="asApplicationSelectList.do")
	@ResponseBody
	public ArrayList<AsApplication> asApplicationSelectList(int index,String searchContent,String selectContent) {
		ArrayList<AsApplication> asApplicationArr = asApplicationService.asApplicationSelectList(searchContent,selectContent);
		ArrayList<AsApplication> asApplicationList = new ArrayList<AsApplication>();
		if(asApplicationArr.size() >= index*5) {
			for(int i=(index-1)*5;i<index*5;i++ ) {
				asApplicationList.add(asApplicationArr.get(i));
			}
		}else {
			for(int i=(index-1)*5;i<asApplicationArr.size();i++ ) {
				asApplicationList.add(asApplicationArr.get(i));
			}
		}		
		return asApplicationList;
	}
}
