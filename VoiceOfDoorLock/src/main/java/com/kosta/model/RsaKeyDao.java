package com.kosta.model;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.dto.RsaKey;

@Repository
public class RsaKeyDao {
	private FactoryDao factoryDao;
	@Autowired
	public void setFactoryDao(FactoryDao factoryDao) {
		this.factoryDao = factoryDao;
		}
	
	public RsaKey selectRsaKey() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from RSA";
		
		try {
			conn = factoryDao.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new RsaKey(rs.getString(3),rs.getString(4),rs.getString(1),rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(conn, pstmt,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return null;
	}
	
	public int insertRsaKey(RsaKey rsaKey) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "insert into RSA values(?,?,?,?)";
		
		try {
			conn = factoryDao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rsaKey.getPublicKeyModulus());
			pstmt.setString(2, rsaKey.getPublicKeyPublicExponent());
			pstmt.setString(3, rsaKey.getPrivateKeyModulus());
			pstmt.setString(4, rsaKey.getPrivateKeyPrivateExponent());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(conn, pstmt,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return 0;
	}
	
	public int updateRsaKey(String getPrivateKeyModulus, RsaKey rsaKey) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("rsa암호 변경");
		String sql = "UPDATE RSA SET PUBLIC_KEY_MODULUS = ?, PUBLIC_KEY_PUBLICEXPONENT = ?, PRIVATE_KEY_MODULUS = ?, PRIVATE_KEY_PRIVATEEXPONENT = ? WHERE PRIVATE_KEY_MODULUS = ?";

		try {
			conn = factoryDao.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rsaKey.getPublicKeyModulus());
			pstmt.setString(2, rsaKey.getPublicKeyPublicExponent());
			pstmt.setString(3, rsaKey.getPrivateKeyModulus());
			pstmt.setString(4, rsaKey.getPrivateKeyPrivateExponent());
		
			pstmt.setString(5, getPrivateKeyModulus);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factoryDao.close(conn, pstmt,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return 0;
	}
}
