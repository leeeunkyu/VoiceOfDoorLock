package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

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
				sql = "SELECT * FROM ENGINEER WHERE BRANCH_NAME = ? ";
			}else if (selectContent.equals("engineerName")) {
				sql = "SELECT * FROM ENGINEER WHERE BRANCH_NAME = ? AND ENGINEER_NAME LIKE ? ";

			}else if(selectContent.equals("isTrip")){
				sql = "SELECT * FROM ENGINEER WHERE BRANCH_NAME = ? AND ISTRIP LIKE ? ";
		
			}else {
				sql = "SELECT * FROM ENGINEER WHERE BRANCH_NAME = ? AND ENGINEER_NUM LIKE ? ";

			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, branchName);
			if(selectContent != null) {
				pstmt.setString(2, "%"+searchContent+"%");
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Engineer(rs.getString("ENGINEER_NUM"),rs.getString("ENGINEER_PHONE"),
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

	public String insertEngineer(String engineerPhone, String engineerName, String branchName, String isTrip) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO ENGINEER VALUES (?,?,?,?,?)";
		
		try {
			con = factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			String engineerNum = selectEngineerNum();
			pstmt.setString(1, engineerNum);
			pstmt.setString(2, engineerPhone);
			pstmt.setString(3, engineerName);
			pstmt.setString(4, branchName);
			pstmt.setString(5, isTrip);
			if(pstmt.executeUpdate() != 0) {
				return engineerNum;
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
		return null;

	}

	public Engineer selectOneEngineer(String engineerNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = factoryDao.getConnection();
			sql = "SELECT * FROM ENGINEER WHERE ENGINEER_NUM = ? ORDER BY APPLICATION_INDEX DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, engineerNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Engineer(rs.getString("ENGINEER_NUM"), rs.getString("ENGINEER_PHONE"),
						rs.getString("ENGINEER_NAME"), rs.getString("BRANCH_NAME"),
						rs.getString("ISTRIP"));
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
		return null;
	}

	public String selectEngineerNum () {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = factoryDao.getConnection();
			sql = "SELECT * FROM ENGINEER order by ENGINEER_NUM desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String engineerNum = rs.getString("ENGINEER_NUM");
				String index = engineerNum.substring(6, 10);
				System.out.println(index+"---");
				int num = Integer.parseInt(index)+1;
				String numLength = ""+num;
				String service = "SE";
				for (int i = 0; i < index.length() - numLength.length(); i++) {
					service+="0";
				}
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				String realEngineerNum = ""+year+service+num;
				System.out.println(realEngineerNum);
				return realEngineerNum;
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
		return null;
	}

	public boolean updateEngineer(String engineerNum,String engineerName, String engineerPhone, String isTrip) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "UPDATE ENGINEER SET ENGINEER_NAME = ? ,ENGINEER_PHONE = ?, ISTRIP = ? WHERE ENGINEER_NUM = ?";
		
		try {
			con = factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, engineerName);
			pstmt.setString(2, engineerPhone);
			pstmt.setString(3, isTrip);
			pstmt.setString(4, engineerNum);

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

	public boolean deleteEngineer(String engineerNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "DELETE FROM ENGINEER WHERE ENGINEER_NUM = ?";
		
		try {
			con = factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, engineerNum);
;

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

	public ArrayList<Engineer> searchEngineer(String branchName, String searchSelect, String searchContent) {
		return null;
	}


}
