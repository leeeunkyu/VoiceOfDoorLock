package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.Log;

@Repository
public class LogDao {

	private FactoryDao factoryDao;

	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}
	
	public ArrayList<Log> logSelectList(String searchContent, String selectContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Log> list = new ArrayList<Log>();
		
		try {
			con = factoryDao.getConnection();
			if (selectContent == null) {
				sql = "SELECT * FROM LOG";
				pstmt = con.prepareStatement(sql);
			}else if (selectContent.equals("memberId")) {
				sql = "SELECT * FROM LOG  WHERE MEMBER_ID LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchContent+"%");
			}else {
				sql = "SELECT * FROM LOG  WHERE LOG_CONTROL LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchContent.toUpperCase()+"%");
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Log(rs.getString("MEMBER_ID"),
						rs.getString("LOG_DATE"),rs.getString("LOG_CONTROL"),
						rs.getString("DOORLOCK_NUM")));
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
