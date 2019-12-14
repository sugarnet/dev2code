package com.dss.jdbc;

import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			
			System.out.println("Connecting to database");
			
			DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection success!!!");
			
		} catch(Exception exception) {
			exception.printStackTrace();
		}

	}

}
