/**
 * 
 */
package com.vinay.hibernatetut;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Dell
 *
 */
public class TestJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String jdbcUrl ="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String userName  = "vinay";
		String password  = "drago";
		try {
			System.out.println("Connecting to database: "+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connection Succesful!!!");
		}catch(Throwable t) {
			t.printStackTrace();
		}
		

	}

}
