package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.AsApplication;

@Repository
public class AsApplicationDao {
	
	private FactoryDao factoryDao;

	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}
	
	public ArrayList<AsApplication> asApplicationSelectList(String searchContent, String selectContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<AsApplication> list = new ArrayList<AsApplication>();
		
		try {
			con = factoryDao.getConnection();
			if (selectContent == null) {
				sql = "SELECT * FROM ASAPPLICATION";
				pstmt = con.prepareStatement(sql);
			}else if (selectContent.equals("memberId")) {
				sql = "SELECT * FROM ASAPPLICATION WHERE MEMBER_ID LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchContent+"%");
			}else {
				sql = "SELECT * FROM ASAPPLICATION WHERE BRANCH_NAME LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchContent+"%");
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new AsApplication(
						rs.getString("APPLICATION_INDEX"), rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_NAME"), rs.getString("MEMBER_PHONE"), 
						rs.getString("MEMBER_ADDRESS"), rs.getString("DOORLOCK_NUM"), 
						rs.getString("BRANCH_NAME"), rs.getString("APPLICATION_DAY")));
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
