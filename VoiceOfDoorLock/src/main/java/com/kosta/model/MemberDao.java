package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.BlockCountByAdmin;
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
						rs.getString("MEMBER_NAME"),rs.getString("MEMBER_PHONE"),
						rs.getString("MEMBER_EMAIL"),rs.getString("NOTIFICATION"),
						rs.getString("LINE_ID"),rs.getString("BLOCK")));
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
						rs.getString("MEMBER_NAME"),rs.getString("MEMBER_PHONE"),
						rs.getString("MEMBER_EMAIL"),rs.getString("NOTIFICATION"),
						rs.getString("LINE_ID"),rs.getString("BLOCK"));
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

	public boolean updateMember(String memberId,boolean state, String adminId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE MEMBER SET BLOCK = ? WHERE MEMBER_ID = ?";
		
		try {
			con = factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			if(state) {
				pstmt.setString(1, "SAFE");
			} else {
				insertBlockByAdmin(memberId,adminId);
				pstmt.setString(1, "LOST");	
			}
			pstmt.setString(2, memberId);
			if(pstmt.executeUpdate() != 0) {
				return true;
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
		return false;
	}

	public void insertBlockByAdmin(String memberId, String adminId) {
		Connection con =null;
		PreparedStatement pstmt =null;
		String sql="INSERT INTO BLOCK_COUNT_BYADMIN VALUES (?,?,?,?)";
		Calendar cal = Calendar.getInstance();
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, adminId);
			pstmt.setString(3, "LOST");
			pstmt.setString(4, cal.get(Calendar.YEAR)+"."+cal.get(Calendar.MONTH)+"."+cal.get(Calendar.DATE)+"  "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));

			if(pstmt.executeUpdate() != 0) {
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<BlockCountByAdmin> blockMemberSelectList(String searchContent, String selectContent) {
		System.out.println("test1");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BlockCountByAdmin> list = new ArrayList<BlockCountByAdmin>();
		
		try {
			con = factoryDao.getConnection();
			if (selectContent == null) {
				sql = "SELECT * FROM BLOCK_COUNT_BYADMIN";
				pstmt = con.prepareStatement(sql);
			}else if (selectContent.equals("memberId")) {
				sql = "SELECT * FROM BLOCK_COUNT_BYADMIN WHERE MEMBER_ID LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchContent+"%");
			}else {
				sql = "SELECT * FROM BLOCK_COUNT_BYADMIN WHERE ADMIN_ID LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchContent+"%");
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BlockCountByAdmin(rs.getString("MEMBER_ID"), rs.getString("ADMIN_ID"), rs.getString("BLOCK_REASON"), rs.getString("BLOCK_DAY")));
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
}
