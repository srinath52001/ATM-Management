package com.nt.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connections {
	
	public  Connection con;
	
	
	public Connections() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb9am","2505");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
