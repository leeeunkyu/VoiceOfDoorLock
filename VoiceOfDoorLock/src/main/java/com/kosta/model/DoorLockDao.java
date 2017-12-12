package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.DoorLock;


@Repository
public class DoorLockDao {
	
	private FactoryDao factoryDao;

	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
	}

	public boolean isDoorLockPassword(String doorLockNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DoorLock doorLock = null;
		String sql = "SELECT * FROM DOORLOCK WHERE DOORLOCK_NUM = ?";
		
		try {
			con = factoryDao.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, doorLockNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("DOORLOCK_PASSWORD").equals(doorLockNum)) {
					return false;
				}
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
		return true;
		
	}

	public boolean insertDoorLock(String doorLockNum, String doorLockPassword) {
		Connection con =null;
		PreparedStatement pstmt =null;
		String sql="INSERT INTO DOORLOCK VALUES (?,?,?)";
		
		try {
			con=factoryDao.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, doorLockNum);
			pstmt.setString(2, doorLockPassword);
			pstmt.setString(3, "X");

			if(pstmt.executeUpdate() != 0) {
				return true;
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
		return false;
	}

}
