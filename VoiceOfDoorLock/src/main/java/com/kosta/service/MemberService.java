package com.kosta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.BlockCountByAdmin;
import com.kosta.dto.Member;
import com.kosta.model.MemberDao;

@Service
public class MemberService {
	
	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public ArrayList<Member> memberSelectList(String searchContent, String selectContent) {
		return memberDao.memberSelectList(searchContent,selectContent);
	}

	public Member memberSelect(String memberId) {
		return memberDao.memberSelect(memberId);
	}

	public boolean updateMember(String memberId,boolean state, String adminId) {
		return memberDao.updateMember(memberId,state,adminId);
	}

	public ArrayList<BlockCountByAdmin> blockMemberSelectList(String searchContent, String selectContent) {
		return memberDao.blockMemberSelectList(searchContent,selectContent);
	}

}
