package com.HealthcareSystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection getConnection() {
		Connection conn = null;
		
		try {
			//database name: paf, username: root, password: root
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/paf?useSSL=false", "root", "root");

		} 
		catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		return conn;
	}
}
