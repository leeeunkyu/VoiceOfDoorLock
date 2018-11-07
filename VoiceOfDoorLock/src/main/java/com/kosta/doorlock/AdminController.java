package com.kosta.doorlock;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.Admin;
import com.kosta.dto.Branch;
import com.kosta.service.AdminService;
import com.kosta.service.BranchService;
import com.kosta.util.AesUtil;
import com.kosta.util.CreateDoorLockNum;
import com.kosta.util.MailSender;

@Controller
public class AdminController {
	
	private static final int KEY_SIZE = 128;
    private static final int ITERATION_COUNT = 10000; 
    private static String RSA_WEB_KEY = "_RSA_WEB_Key_"; // 개인키 session key
    private static String RSA_INSTANCE = "RSA"; // rsa transformation
    
	AdminService adminService;
	BranchService branchService;
	
	@Autowired
	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}
	
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
	public ModelAndView login(HttpServletRequest req) {
		initRsa(req);	//publickey privatekey 생성 session에 저장
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
	public ModelAndView login(HttpSession session) {
		ModelAndView mv = new ModelAndView();
        session.removeAttribute(AdminController.RSA_WEB_KEY);

		mv.addObject("loginSucc", "ok");
		mv.setViewName("home");
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
			if(mailSender.send(adminEmail,token)) {
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
	
	@RequestMapping(value="updateView.do")
	public ModelAndView updateView(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(sessionCheck(session)) {
			Admin admin = adminService.selectAdminOne((String)session.getAttribute("adminId"));
			Branch branch = branchService.selectBranchOne((String)session.getAttribute("branchName"));
			mv.addObject("admin", admin);
			mv.addObject("branch", branch);
			mv.setViewName("branch/updateinfo");
			return mv;			
		}else {
			mv.setViewName("error/errormain");
			mv.addObject("errorType","notMaster");
		}
			return mv;
	}
	
	public void initRsa(HttpServletRequest request) {
		System.out.println("RSA키생성");
        HttpSession session = request.getSession();
 
        KeyPairGenerator generator;
        try {
            generator = KeyPairGenerator.getInstance(AdminController.RSA_INSTANCE);
            generator.initialize(1024);
 
            KeyPair keyPair = generator.genKeyPair();
            KeyFactory keyFactory = KeyFactory.getInstance(AdminController.RSA_INSTANCE);
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
 
            session.setAttribute(AdminController.RSA_WEB_KEY, privateKey); // session에 RSA 개인키를 세션에 저장
 
            RSAPublicKeySpec publicSpec = (RSAPublicKeySpec) keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
            String publicKeyModulus = publicSpec.getModulus().toString(16);
            String publicKeyExponent = publicSpec.getPublicExponent().toString(16);
 
            request.setAttribute("RSAModulus", publicKeyModulus); // rsa modulus 를 request 에 추가
            request.setAttribute("RSAExponent", publicKeyExponent); // rsa exponent 를 request 에 추가
            System.out.println("공개키 모듈"+publicKeyModulus);
            System.out.println("공개키 지수"+publicKeyExponent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@RequestMapping(value="RsaAestest.do" ,method = RequestMethod.GET)
	@ResponseBody
	public Map RsaAestest(HttpServletRequest request) throws Exception {
		String rsaAesId = request.getParameter("rsaAesId");
		String rsaAesPw = request.getParameter("rsaAesPw");
		String rsaAesIv = request.getParameter("rsaAesIv");
		String rsaAesSalt = request.getParameter("rsaAesSalt");
		String rsaAesPassPhrase = request.getParameter("rsaAesPassPhrase");
		HttpSession session = request.getSession();
        PrivateKey privateKey = (PrivateKey) session.getAttribute(AdminController.RSA_WEB_KEY);
 
        // 복호화
        rsaAesId = decryptRsa(privateKey, rsaAesId);
        rsaAesPw = decryptRsa(privateKey, rsaAesPw);
        rsaAesIv = decryptRsa(privateKey, rsaAesIv);
        rsaAesSalt = decryptRsa(privateKey, rsaAesSalt);
        rsaAesPassPhrase = decryptRsa(privateKey, rsaAesPassPhrase);
        System.out.println("PassPhrase 값: "+rsaAesPassPhrase);
		AesUtil aesUtil = new AesUtil(KEY_SIZE, ITERATION_COUNT);
		String decryptId = aesUtil.decrypt(rsaAesSalt, rsaAesIv, rsaAesPassPhrase, rsaAesId);
		String decryptPw = aesUtil.decrypt(rsaAesSalt, rsaAesIv, rsaAesPassPhrase, rsaAesPw);
		Map<String,String>  map = adminService.selectAdmin(decryptId,decryptPw);
		Map<String, String> challenge = null;
		if(map != null && map.get("adminGrade") != null) {
			session.setAttribute("adminId", decryptId);
			session.setAttribute("adminGrade", map.get("adminGrade"));
			session.setAttribute("branchName", map.get("branchName"));
			
			challenge = new HashMap<String,String>();
			String logicSymbol[] = {"+","-","*","/"};
			Random random = new Random();
			challenge.put("islogin", "ok");
			challenge.put("first", ""+random.nextInt(10));
			challenge.put("second", logicSymbol[random.nextInt(4)]);
			challenge.put("third", ""+random.nextInt(10));
			challenge.put("fourth", logicSymbol[random.nextInt(4)]);
			challenge.put("fifth", ""+random.nextInt(10));
			challengeLogic(challenge,request);
		}else {
			challenge = new HashMap<String,String>();
			challenge.put("islogin", "fail");
		}
		return challenge;
	}
	public void challengeLogic(Map<String, String> challenge, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int firstLogic;
		int secondLogic;
		if(challenge.get("second").equals("+")) {
			firstLogic = Integer.parseInt(challenge.get("first")) + Integer.parseInt(challenge.get("third"));
		}else if(challenge.get("second").equals("*")) {
			firstLogic = Integer.parseInt(challenge.get("first")) * Integer.parseInt(challenge.get("third"));
		}else if(challenge.get("second").equals("-")) {
			firstLogic = Integer.parseInt(challenge.get("first")) - Integer.parseInt(challenge.get("third"));
		}else {
			if(Integer.parseInt(challenge.get("third")) == 0) {
				firstLogic = Integer.parseInt(challenge.get("first")) / 1;
			}else {
				firstLogic = Integer.parseInt(challenge.get("first")) / Integer.parseInt(challenge.get("third"));
			}
		}
		if(challenge.get("fourth").equals("+")) {
			secondLogic = firstLogic + Integer.parseInt(challenge.get("fifth"));
		}else if(challenge.get("fourth").equals("*")) {
			secondLogic = firstLogic * Integer.parseInt(challenge.get("fifth"));

		}else if(challenge.get("fourth").equals("-")) {
			secondLogic = firstLogic - Integer.parseInt(challenge.get("fifth"));
		}else {
			if(Integer.parseInt(challenge.get("fifth")) == 0) {
				secondLogic = firstLogic / 1;
			}else {
				secondLogic = firstLogic / Integer.parseInt(challenge.get("fifth"));
			}
		}
		session.setAttribute("challengeResponse",""+secondLogic);
	}
	
	@RequestMapping(value="logicResponse.do" , method = RequestMethod.GET)
	@ResponseBody
	public boolean logicResponse(HttpServletRequest request,String cResponse) {
		HttpSession session = request.getSession();
		if(cResponse.equals((String)session.getAttribute("challengeResponse"))) {
			return true;
		}else {
			return false;
		}
	}
	
	private String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
        Cipher cipher = Cipher.getInstance(AdminController.RSA_INSTANCE);
        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
        return decryptedValue;
    }
 
    /**
     * 16진 문자열을 byte 배열로 변환한다.
     * 
     * @param hex
     * @return
     */
    public static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() % 2 != 0) { return new byte[] {}; }
 
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
            bytes[(int) Math.floor(i / 2)] = value;
        }
        return bytes;
    }

}
