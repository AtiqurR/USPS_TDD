package com.baseClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC2DArray {
	
	public static void main(String[] args) throws ClassNotFoundException {
		String[][] dataStrings = dbConnect();
		for(int i = 0; i < dataStrings.length; i++) {
			System.out.println("ID:" + dataStrings[i][0] +". Name:"+ dataStrings[i][1] +". Region:"+dataStrings[i][2]);
		}
	}

	public static String[][] dbConnect() throws ClassNotFoundException {
		String [][] dataStrings =null;
		Connection connection = null;
		Statement statement = null;
		ResultSet set = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			statement = connection.createStatement();
			set = statement.executeQuery("SELECT * FROM COUNTRIES");
			
			dataStrings = new String[25][3];
			
			/*
			 * set.next(); System.out.println(set.getObject("COUNTRY_ID")); set.next();
			 * System.out.println(set.getObject("COUNTRY_ID")); set.next();
			 * System.out.println(set.getObject("COUNTRY_ID"));
			 */
			int i = 0;
			
			while (set.next()) {
				dataStrings[i][0] = set.getString("COUNTRY_ID");
				dataStrings[i][1] = set.getString("COUNTRY_NAME");
				dataStrings[i][2] = set.getString("REGION_ID");
				i++;
				//System.out.println("Country_Id : " + set.getObject("COUNTRY_ID") + ". Country_Name:"
					//	+ set.getObject("COUNTRY_NAME") + ". Region_Id:" + set.getObject("REGION_ID"));
			}
			
			//System.out.println(i);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dataStrings;
	}

	/*
	 * JDBC - JDBC is a java tools to read and write into database using connectors. 
	 * 1. Maven Dependency (Oracle - ojdbc, MySql - MySql connector j) 2. Register
	 * Driver (oracle.jdbc.driver.OracleDriver)(jdbc.cj.mysql.connector) 3. 
	 */

}
