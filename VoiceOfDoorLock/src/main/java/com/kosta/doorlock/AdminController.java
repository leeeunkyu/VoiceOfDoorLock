package com.kosta.doorlock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.Admin;
import com.kosta.service.AdminService;

@Controller
public class AdminController {
	
	AdminService adminService;
	
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public boolean sessionCheck(HttpSession session) {
		if(session.getAttribute("adminId") != null) {
			return true;
		}
		return false;
	}
	
	
	@RequestMapping(value="signup.do" , method = RequestMethod.GET)
	public String signUp() {
		return "admin/signup";
	}
	@RequestMapping(value="login.do")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="keyCreateView.do")
	public ModelAndView keyCreateView(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(sessionCheck(session)) {
			mv.setViewName("key/keyCreateView");
			return mv;			
		}else {
			mv.setViewName("error/errormain");
			mv.addObject("errorType","notMaster");
		}
			return mv;
		
	}
	
	@RequestMapping(value="logout.do")
	public String logut(HttpSession session) {
		if (session.getAttribute("adminId") != null) {
			session.removeAttribute("adminId");
			session.setMaxInactiveInterval(0);
			session.invalidate();
		}
		return "home";
	}
	
	@RequestMapping(value="adminAdd.do")
	public ModelAndView adminAdd(Admin admin) {
		ModelAndView mv = new ModelAndView();
		System.out.println(admin.toString());
		if(adminService.addAdmin(admin)) {
			mv.setViewName("home");
		}else {
			
		}
		return mv;
	}
	
	@RequestMapping(value="branchname.do")
	public String branchnname() {
		return "admin/branchname";
	}
	
	@RequestMapping(value="confirmBranch.do" ,method = RequestMethod.POST)
	public void confirmBranch(String branchName,String branchCode,HttpServletResponse res) throws IOException {
		if(adminService.confirmBranch(branchName,branchCode))
			res.getWriter().print("ok");
		else
			res.getWriter().print("fail");
	}
	
	@RequestMapping(value="isId.do")
	@ResponseBody
	public boolean isId(String adminId) {
		if(adminService.isId(adminId)) {
			return true;
		} else {
			return false;			
		}
	}
	
	@RequestMapping(value="selectAdmin.do" ,method = RequestMethod.GET)
	public ModelAndView login(HttpSession session,String adminId,String adminPw) {
		ModelAndView mv = new ModelAndView();
		Map<String,String>  map = adminService.selectAdmin(adminId,adminPw);
		if(map.get("adminGrade") != null) {
			session.setAttribute("adminId", adminId);
			session.setAttribute("adminGrade", map.get("adminGrade"));
			session.setAttribute("branchName", map.get("branchName"));
		}else {
			session.setAttribute("adminId", null);
			session.setAttribute("adminGrade", null);
		}
		mv.setViewName("home");

		return mv;
	}
}
