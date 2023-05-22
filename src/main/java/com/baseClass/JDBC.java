package com.baseClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException {
		dbConnect();
	}

	public static void dbConnect() throws ClassNotFoundException {
		Connection connection = null;
		Statement statement = null;
		ResultSet set = null;
		System.out.println("connected");
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		//	Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("connected");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("connected");
			statement = connection.createStatement();
			System.out.println("connected");
			set = statement.executeQuery("SELECT * FROM EMPLOYEES");
			System.out.println(set.getFetchSize());
			//System.out.println(set.next());
			while (set.next()) {
				System.out.println(	set.getObject("FIRST_NAME"));
				System.out.println(set.getString("EMPLOYEE_ID"));
				System.out.println(set.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


			


	/*
	 * JDBC - JDBC is a java tools to read and write into database using connectors. 
	 * 1. Maven Dependency (Oracle - ojdbc, MySql - MySql connector j) 2. Register
	 * Driver (oracle.jdbc.driver.OracleDriver)(jdbc.cj.mysql.connector) 3. 
	 */


