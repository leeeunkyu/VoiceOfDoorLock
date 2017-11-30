package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.AsApplication;
import com.kosta.dto.Engineer;
import com.kosta.service.EngineerService;

@Repository
public class EngineerDao {


	private FactoryDao factoryDao;

	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}
	
	public ArrayList<Engineer> engineerSelectList(String searchContent, String selectContent, String branchName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<Engineer> list = new ArrayList<Engineer>();
		
		try {
			con = factoryDao.getConnection();
			if (selectContent == null) {
				sql = "SELECT * FROM ENGINEER WHERE BRANCH_NAME = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, branchName);
			}else if (selectContent.equals("engineerName")) {
				sql = "SELECT * FROM ENGINEER WHERE BRANCH_NAME = ? AND ENGINEER_NAME LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, branchName);
				pstmt.setString(2, "%"+searchContent+"%");
			}else {
				sql = "SELECT * FROM ENGINEER WHERE BRANCH_NAME = ? AND ISTRIP LIKE ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, branchName);
				pstmt.setString(2, "%"+searchContent+"%");
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Engineer(rs.getString("ENGINEER_PHONE"),
						rs.getString("ENGINEER_NAME"), rs.getString("BRANCH_NAME"),
						rs.getString("ISTRIP")));
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

	public boolean insertEngineer(String engineerPhone, String engineerName, String branchName, String isTrip) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO ENGINEER VALUES (?,?,?,?)";
		
		try {
			con = factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, engineerPhone);
			pstmt.setString(2, engineerName);
			pstmt.setString(3, branchName);
			pstmt.setString(4, isTrip);
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



}
