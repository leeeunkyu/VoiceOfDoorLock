package com.kosta.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class FactoryDao {
	private String driver;
	private static String url;
	private static String username;
	private static String password;
	private static Map dbserver = null;
	private static FactoryDao factory;

	private FactoryDao(Map dbserver) {
		this.dbserver = dbserver;		
		driver = dbserver.get("driver").toString();
		url = dbserver.get("url").toString();
		username = dbserver.get("username").toString();
		password = dbserver.get("password").toString();
		try {			
			Class.forName(dbserver.get("driver").toString() );	
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password); 
	}
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs ) throws SQLException {
		if(rs != null){	rs.close(); }
		if(pstmt != null){ pstmt.close(); }
		if(con != null){ con.close(); }
	}
	
	public static FactoryDao getInstance() {
		return factory;
	}
	
	public static FactoryDao getInstance(Map map) {
		if(factory == null) {
			factory = new FactoryDao(map);
		}
		return factory;
	}
}
