package com.kosta.doorlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.Branch;
import com.kosta.dto.Engineer;
import com.kosta.dto.Member;
import com.kosta.service.BranchService;
import com.kosta.service.EngineerService;
import com.kosta.service.MemberService;

@Controller
public class EngineerController {
	EngineerService engineerService;
	MemberService memberService;
	BranchService branchService;
	
	@Autowired
	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Autowired
	public void setEngineerService(EngineerService engineerService) {
		this.engineerService = engineerService;
	}
	
	public boolean sessionCheck(HttpSession session) {
		if(session.getAttribute("adminId") != null) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="selectOneEngineer")
	@ResponseBody
	public Engineer selectOneEngineer(HttpSession session, String engineerPhone) {
		Engineer engineer = engineerService.selectOneEngineer(engineerPhone);
		
		return engineer;
	}	
	
	@RequestMapping(value="engineerListView.do")
	public ModelAndView engineerListView(HttpSession session,String branchName,String memberId) {
		
		ModelAndView mv = new ModelAndView();
		if(sessionCheck(session)) {
			ArrayList<Engineer> engineerArr = engineerService.engineerSelectList(null,null,branchName);
			if(engineerArr.size() <=0) {
				mv.setViewName("error/notengineer");
			}else {
				Member member = memberService.memberSelect(memberId);
				mv.addObject("engineerListSize", ""+engineerArr.size());
				mv.addObject("engineerList", engineerArr);
				mv.addObject("member",member);
				mv.setViewName("engineer/engineerlist");
			}
		}else {
			mv.addObject("errorType", "notAdmin");
			mv.setViewName("error/errormain");
		}
		return mv;
	}
	
	@RequestMapping(value="engineerSelectSize.do")
	@ResponseBody
	public int engineerSelectSize(String searchContent,String selectContent,String branchNaem) {
		ArrayList<Engineer> engineerArr = engineerService.engineerSelectList(searchContent,selectContent,branchNaem);
		int length = engineerArr.size();
		
		return length;
	}
	
	
	
	@RequestMapping(value="engineerSelectList.do")
	@ResponseBody
	public ArrayList<Engineer> engineerSelectList(HttpServletResponse res,HttpServletRequest req,int index,String branchName,String searchContent,String selectContent) {
		ArrayList<Engineer> engineerArr = engineerService.engineerSelectList(searchContent,selectContent,branchName);
		ArrayList<Engineer> engineerList = new ArrayList<Engineer>();
		if(engineerArr.size() >= index*5) {
			for(int i=(index-1)*5;i<index*5;i++ ) {
				engineerList.add(engineerArr.get(i));
			}
		}else {
			for(int i=(index-1)*5;i<engineerArr.size();i++ ) {
				engineerList.add(engineerArr.get(i));
			}
		}

		return engineerList;
	}
	
	@RequestMapping(value="tripEngineer.do")
	@ResponseBody
	public Map tripEngineer(HttpServletResponse res,HttpServletRequest req,String engineerPhone,String engineerName,String memberId,String branchName) {
		System.out.println("engineerPhone:"+engineerPhone);
		System.out.println("engineerName:"+engineerName);
		System.out.println("memberId:"+memberId);
		System.out.println("branchName:"+branchName);
		
		Member member = memberService.memberSelect(memberId);
		Branch branch = branchService.branchSelect(branchName);
		//hash 이용시 안됨
		// RestTemplate 에 MessageConverter 세팅
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(converters);

		// parameter 세팅
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("location", branch.getBranchName());
		map.add("engineerName", engineerName);
		map.add("engineerPhone", engineerPhone);
		map.add("latitude", branch.getBranchLatitude());
		map.add("longitude", branch.getBranchLongitude());
		map.add("LineId", member.getLineId());
		// post
		String result = restTemplate.postForObject("https://gentle-refuge-88758.herokuapp.com/tripEngineer", map, String.class);
		System.out.println(result);
		
		String str ="test231";
		map.add("memberName", member.getMemberName());
		System.out.println(result);
		return map;
	}
	
	@RequestMapping(value="updateEngineer.do")
	@ResponseBody
	public String updateEngineer(String engineerNum,String engineerName,String engineerPhone,String isTrip) {
		if(engineerService.updateEngineer(engineerNum,engineerName,engineerPhone,isTrip)) {
			return "true";			
		}
			return "false";
	}
	
}
