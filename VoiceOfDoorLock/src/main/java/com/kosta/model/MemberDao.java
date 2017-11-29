package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.Member;

@Repository
public class MemberDao {

	private FactoryDao factoryDao;

	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}

	public ArrayList<Member> memberSelectList(String searchContent, String selectContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			con = factoryDao.getConnection();
			if (selectContent == null) {
				sql = "SELECT * FROM MEMBER";
				pstmt = con.prepareStatement(sql);
			}else if (selectContent.equals("memberId")) {
				sql = "SELECT * FROM MEMBER WHERE MEMBER_ID LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchContent+"%");
			}else {
				sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchContent+"%");
			}
			System.out.println("sql: "+sql+" searchContent: "+searchContent );
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Member(rs.getString("MEMBER_ID"),rs.getString("MEMBER_PW"),
						rs.getString("MEMBER_NAME"),rs.getString("MEMBER_PHONE"),rs.getString("MEMBER_ADDRESS"),
						rs.getString("MEMBER_EMAIL"),rs.getString("NOTIFICATION"),
						rs.getString("MEMBER_PUBLICKEY"),rs.getString("LINE_ID"),rs.getString("BLOCK")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public Member memberSelect(String memberId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
		
		try {
			con = factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member =new Member(rs.getString("MEMBER_ID"),rs.getString("MEMBER_PW"),
						rs.getString("MEMBER_NAME"),rs.getString("MEMBER_PHONE"),rs.getString("MEMBER_ADDRESS"),
						rs.getString("MEMBER_EMAIL"),rs.getString("NOTIFICATION"),
						rs.getString("MEMBER_PUBLICKEY"),rs.getString("LINE_ID"),rs.getString("BLOCK"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}
}
