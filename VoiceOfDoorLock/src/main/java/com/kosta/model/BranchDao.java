package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.Branch;

@Repository
public class BranchDao {

	private FactoryDao factoryDao;

	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}
	
	public Branch branchSelect(String branchName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Branch branch = null;
		String sql = "SELECT * FROM BRANCH WHERE BRANCH_NAME = ?";		
		try {
			con = factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, branchName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				branch =new Branch(rs.getString("BRANCH_NAME"),rs.getString("BRANCH_NUM"),
						rs.getString("BRANCH_LATITUDE"),rs.getString("BRANCH_LONGITUDE")
						,rs.getString("BRANCH_PHONE"),rs.getString("BRANCH_EMAIL"));
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
		return branch;
	}

	public void insertBranch(Branch branch) {
		Connection con =null;
		PreparedStatement pstmt =null;
		String sql="INSERT INTO BRANCH VALUES (?,?,?,?,?,?)";
		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, branch.getBranchName());
			pstmt.setString(2, branch.getBranchNum());
			pstmt.setString(3, branch.getBranchLatitude());
			pstmt.setString(4, branch.getBranchLongitude());
			pstmt.setString(5, branch.getBranchPhone());
			pstmt.setString(6, branch.getBranchEmail());

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
}

