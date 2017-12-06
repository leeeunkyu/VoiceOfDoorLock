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
import com.kosta.util.CreateBranchNum;
import com.kosta.util.CreateDoorLockNum;
import com.kosta.util.MailSender;

@Controller
public class AdminController {
	
	AdminService adminService;
	
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	/**
	 * 사용자 세션 체크를 위한 함수. 주요페이지마다 세션을 체크해 사용자 id에 대한 세션정보가 남아있을경우 true 없을경우 false를 반환한다.
	 * @param session
	 * @return
	 */
	public boolean sessionCheck(HttpSession session) {
		if(session.getAttribute("adminId") != null) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="signUp.do" , method = RequestMethod.GET)
	public String signUp() {
		return "admin/signup";
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
	@RequestMapping(value="branchName.do")
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
	@RequestMapping(value="adminAdd.do")
	public ModelAndView adminAdd(Admin admin) {
		ModelAndView mv = new ModelAndView();
		if(adminService.addAdmin(admin)) {
			mv.setViewName("home");
		}else {
			
		}
		return mv;
	}
	
	
	
	@RequestMapping(value="login.do")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("islogin", "wait");
		mv.setViewName("admin/login");
		return mv;
	}
	@RequestMapping(value="logout.do")
	public ModelAndView logut(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("logoutSucc", "ok");
		mv.setViewName("home");
		if (session.getAttribute("adminId") != null) {
			session.removeAttribute("adminId");
			session.setMaxInactiveInterval(0);
			session.invalidate();
		}
		return mv;
	}
	@RequestMapping(value="selectAdmin.do" ,method = RequestMethod.GET)
	public ModelAndView login(HttpSession session,String adminId,String adminPw) {
		ModelAndView mv = new ModelAndView();
		Map<String,String>  map = adminService.selectAdmin(adminId,adminPw);

		if(map != null && map.get("adminGrade") != null) {
			session.setAttribute("adminId", adminId);
			session.setAttribute("adminGrade", map.get("adminGrade"));
			session.setAttribute("branchName", map.get("branchName"));
			mv.addObject("loginSucc", "ok");
			mv.setViewName("home");
		}else {
			mv.addObject("islogin", "false");
			mv.setViewName("admin/login");
			session.setAttribute("adminId", null);
			session.setAttribute("adminGrade", null);
		}

		return mv;
	}
	
	
	
	@RequestMapping(value="selectAdminIdView.do" , method = RequestMethod.GET)
	public String selectAdminIdView() {
		return "admin/selectadminid";
	}
	@RequestMapping(value="selectAdminId.do")
	@ResponseBody
	public String selectAdminId(String adminName,String branchName,String branchNum) {
		String adminId = adminService.selectAdminId(adminName,branchName,branchNum);
		if(adminId == null) {
			adminId = "noId";
		}
		return adminId;
	}
	
	
	@RequestMapping(value="selectAdminPwView.do" , method = RequestMethod.GET)
	public String selectAdminPwView() {
		return "admin/selectadminpw";
	}
	@RequestMapping(value="selectAdminPw.do")
	@ResponseBody
	public boolean selectAdminPw(String adminId,String branchName,String branchNum) {
		boolean result = false;
		if(adminService.selectAdminPw(adminId,branchName,branchNum)) {
			result = true;
		}
		return result;
	}
	@RequestMapping(value="updatePwView.do" , method = RequestMethod.GET)
	public ModelAndView updatePwView(String adminId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/updatepw");
		mv.addObject("adminId",adminId);
		return mv;
	}
	@RequestMapping(value="sendEmail.do" , method = RequestMethod.GET)
	@ResponseBody
	public boolean sendEmail(HttpSession session,String adminId) {
		String adminEmail = adminService.selectAdminEmail(adminId);
		if(adminEmail != null) {
			String token = CreateDoorLockNum.doorLockNumGenerate();
			session.setAttribute("token", token);
			MailSender mailSender = new MailSender();
			if(mailSender.send("xdkyu01@gmail.com",token)) {
				return true;			
			}else {
				return false;
			}
		}else {
			return false;
		}
	
	}
	@RequestMapping(value="tokenCheck.do" , method = RequestMethod.GET)
	@ResponseBody
	public boolean tokenCheck(HttpSession session, String token) {
		System.out.println("token: "+token);
		System.out.println("sessiontoken: "+(String)session.getAttribute("token"));

		if(token.equals((String)session.getAttribute("token"))){
			return true;			
		}else {
			return false;
		}
	}
	@RequestMapping(value="updatePw.do" , method = RequestMethod.GET)
	@ResponseBody
	public boolean updatePw(String adminId,String adminPw) {
		if(adminService.updateAdminPw(adminId,adminPw)) {
			return true;
			
		}else {
			return false;
		}
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
	
}
