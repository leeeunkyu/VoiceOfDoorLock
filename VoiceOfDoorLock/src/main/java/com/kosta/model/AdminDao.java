package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.Admin;
import com.kosta.util.CryptoAlgorithm;

@Repository
public class AdminDao {
	
	private FactoryDao factoryDao;

	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}

	public boolean isBranch(String branchName, String branchCode) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql="SELECT * FROM BRANCH WHERE BRANCH_NAME = ?";
		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, branchName);
			rs=pstmt.executeQuery();
			while(rs.next()){

				if(rs.getString("BRANCH_NUM").trim().equals(branchCode.trim())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean addAdmin(Admin admin) {
		Connection con =null;
		PreparedStatement pstmt =null;
		String cryptoPw = CryptoAlgorithm.convertSha(admin.getAdminPw());
		String sql="INSERT INTO ADMIN VALUES (?,?,?,?,?,?)";
		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, admin.getAdminId());
			pstmt.setString(2, cryptoPw);
			pstmt.setString(3, admin.getAdminEmail());
			pstmt.setString(4, admin.getAdminName());
			pstmt.setString(5, admin.getAdminGrade());
			pstmt.setString(6, admin.getBranchName());
			System.out.println(admin.toString());
			if(pstmt.executeUpdate() != 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Map<String, String> selectAdmin(String adminId, String adminPw) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String cryptoPw = CryptoAlgorithm.convertSha(adminPw);
		String sql="SELECT * FROM ADMIN WHERE ADMIN_ID=?";
		Map<String, String> map = new HashMap<String, String>();
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				if(rs.getString("ADMIN_PW").equals(cryptoPw)) {
					map.put("adminGrade",  rs.getString("ADMIN_GRADE"));
					map.put("branchName",  rs.getString("BRANCH_NAME"));

					return map;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean isId(String adminId) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql="SELECT * FROM ADMIN WHERE ADMIN_ID=?";		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public String selectAdminId(String adminName, String branchName, String branchNum) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		if(!isBranch(branchName, branchNum)) {
			return null;
		}
		String sql="SELECT ADMIN_ID FROM ADMIN WHERE ADMIN_NAME=? AND BRANCH_NAME = ?";		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, adminName);
			pstmt.setString(2, branchName);

			rs=pstmt.executeQuery();
			while(rs.next()){
				return rs.getString("ADMIN_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean selectAdminPw(String adminId, String branchName, String branchNum) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		if(!isBranch(branchName, branchNum)) {
			return false;
		}
		String sql="SELECT ADMIN_PW FROM ADMIN WHERE ADMIN_ID=? AND BRANCH_NAME = ?";		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			pstmt.setString(2, branchName);

			rs=pstmt.executeQuery();
			while(rs.next()){
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

	public boolean updateAdminPw(String adminId, String adminPw) {
		Connection con =null;
		PreparedStatement pstmt =null;
		String cryptoPw = CryptoAlgorithm.convertSha(adminPw);

		String sql="UPDATE ADMIN SET ADMIN_PW = ? WHERE ADMIN_ID = ?";
		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, cryptoPw);
			pstmt.setString(2, adminId);
		
			if(pstmt.executeUpdate() != 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(con, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public String selectAdminEmail(String adminId) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
	
		String sql="SELECT ADMIN_EMAIL FROM ADMIN WHERE ADMIN_ID=? ";		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, adminId);

			rs=pstmt.executeQuery();
			while(rs.next()){
				return rs.getString("ADMIN_EMAIL");
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

	public Admin selectAdminOne(String adminId) {
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
	
		String sql="SELECT * FROM ADMIN WHERE ADMIN_ID=? ";		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, adminId);

			rs=pstmt.executeQuery();
			while(rs.next()){
				return new Admin(adminId, rs.getString("ADMIN_PW"),
						rs.getString("ADMIN_EMAIL"), rs.getString("ADMIN_NAME"), 
						rs.getString("ADMIN_GRADE"), rs.getString("BRANCH_NAME"));
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
}
