package com.HealthcareSystem.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public Connection getConnection() {
		Connection conn = null;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/paf?useSSL=false", "root", "");

		} 
		catch (Exception e)
		 {
			 e.printStackTrace();
		 }
		return conn;
	}
}
