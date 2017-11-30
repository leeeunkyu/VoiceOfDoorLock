package com.kosta.doorlock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.AsApplication;
import com.kosta.service.DoorLockService;
import com.kosta.service.EngineerService;
import com.kosta.util.CreateDoorLockNum;

@Controller
public class BranchController {
	
	private EngineerService engineerService;
	private DoorLockService doorLockService;
	
	@Autowired
	public void setDoorLockService(DoorLockService doorLockService) {
		this.doorLockService = doorLockService;
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

	@RequestMapping(value="branchMainView.do")
	public ModelAndView branchMainView(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(sessionCheck(session)) {
			mv.setViewName("branch/branchmain");
		}else {
			mv.addObject("errorType", "notAdmin");
			mv.setViewName("error/errormain");
		}
		return mv;
	}
	
	@RequestMapping(value="insertDoorKeyView.do")
	public ModelAndView insertDoorKeyView(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(sessionCheck(session)) {
			mv.setViewName("branch/doorlockCreate");
		}else {
			mv.addObject("errorType", "notAdmin");
			mv.setViewName("error/errormain");
		}
		return mv;
	}
	
	@RequestMapping(value="insertDoorKey.do")
	@ResponseBody
	public Map insertDoorKey() {
		Map map = new HashMap<String,String>();
		String doorLockNum = null;
		while(true) {
			doorLockNum = CreateDoorLockNum.doorLockNumGenerate();
			if (doorLockService.isDoorLockPassword(doorLockNum)) {
				break;
			}	
		}
		String doorLockPassword = CreateDoorLockNum.passwordGenerate();
		map.put("doorLockNum", doorLockNum);
		map.put("doorLockPassword", doorLockPassword);
		if(doorLockService.insertDoorLock(doorLockNum,doorLockPassword)) {
			map.put("doorLockOk", "성공적으로 등록 되었습니다.");

		}else {
			map.put("doorLockOk", "등록에 실패했습니다 다시 시도해 주세요.");

		}
		return map;
	}
	
	@RequestMapping(value="insertEngineerView.do")
	public ModelAndView insertEngineerView(HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		if(sessionCheck(session)) {
			mv.setViewName("branch/insertengineer");
		}else {
			mv.addObject("errorType", "notAdmin");
			mv.setViewName("error/errormain");
		}
		return mv;
	}
	@RequestMapping(value="insertBranchView.do")
	public ModelAndView insertBranchView(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String adminGrade = (String)session.getAttribute("adminGrade");
		if(adminGrade == null || "B".equals(adminGrade)) {
			mv.addObject("errorType","notMaster");
			mv.setViewName("error/errormain");
		}else {
			mv.setViewName("branch/insertbranch");
		}
		return mv;
		
	}
	@RequestMapping(value="updateEngineerView.do" )
	public String updateEngineerView() {
		return "branch/updateengineer";
	}
	
	@RequestMapping(value="insertEngineer.do", method=RequestMethod.POST )
	public ModelAndView insertEngineer(MultipartHttpServletRequest request,
        MultipartFile uploadFile, Object obj,String engineerPhone,String engineerName,String isTrip,String branchName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("branch/branchmain");
		String path = "";
        String fileName = "";
        
        OutputStream out = null;
        PrintWriter printWriter = null;
        
        try {
            fileName = engineerPhone+".png";
            byte[] bytes = uploadFile.getBytes();
            path = getSaveLocation(request, obj);
            
            System.out.println("UtilFile fileUpload fileName : " + fileName);
            System.out.println("UtilFile fileUpload uploadPath : " + path);
            
            File file = new File(path);
            
//          파일명이 중복으로 존재할 경우
            if (fileName != null && !fileName.equals("")) {
                if (file.exists()) {                    
                    
                    file = new File(path + fileName);
                }
            }
            
            System.out.println("UtilFile fileUpload final fileName : " + fileName);
            System.out.println("UtilFile fileUpload file : " + file);
            
            out = new FileOutputStream(file);
            
            System.out.println("UtilFile fileUpload out : " + out);
            
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        engineerService.insertEngineer(engineerPhone,engineerName,branchName,isTrip);
        return mv;
  	}
private String getSaveLocation(MultipartHttpServletRequest request, Object obj) {
        
        String uploadPath = request.getSession().getServletContext().getRealPath("/");
        String attachPath = "resources/images/engineer/";
        
        System.out.println("UtilFile getSaveLocation path : " + uploadPath + attachPath);
        
        return uploadPath + attachPath;
    }


	
}
