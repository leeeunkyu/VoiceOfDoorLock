package com.kosta.doorlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dto.Member;
import com.kosta.service.MemberService;

@Controller
public class MemberController {

	private MemberService memberService;
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value="memberListView.do")
	public ModelAndView memberListView() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Member> memberArr = memberService.memberSelectList(null,null);
		mv.addObject("memberListSize", ""+memberArr.size());
		mv.setViewName("member/memberlist");
		return mv;
	}
	
	@RequestMapping(value="memberSelectSize.do")
	@ResponseBody
	public int memberSelectSize(String searchContent,String selectContent) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Member> memberArr = memberService.memberSelectList(searchContent,selectContent);
		int length = memberArr.size();
		System.out.println("길이 초기화: "+length);
		return length;
	}
	
	
	@RequestMapping(value="memberSelectList.do")
	@ResponseBody
	public ArrayList<Member> memberSelectList(int index,String searchContent,String selectContent) {

		ArrayList<Member> memberArr = memberService.memberSelectList(searchContent,selectContent);
		ArrayList<Member> memberList = new ArrayList<Member>();
		if(memberArr.size() >= index*5) {
			for(int i=(index-1)*5;i<index*5;i++ ) {
				memberList.add(memberArr.get(i));
			}
		}else {
			for(int i=(index-1)*5;i<memberArr.size();i++ ) {
				memberList.add(memberArr.get(i));
			}
		}
		//System.out.println(memberList.size());
		for (int i = 0; i < memberList.size(); i++) {
		//	System.out.println(memberList.get(i).getMemberId());
			
		}
		System.out.println("화면에 뿌려줘");
		return memberList;
	}
}
