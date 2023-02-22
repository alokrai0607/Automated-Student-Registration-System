package com.StudentManagementSystem.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
	
	public static Connection provideConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/Student_registration";
		
		try {
	    private	conn = DriverManager.getConnection(url,"root","0303");
	    System.out.println("Connected to database Sucessfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}

}
