package com.nt.conn;

import java.sql.PreparedStatement;

public class Issues_db {

	public void getIssues(String email, String mobile, String issue) {

		Connections c = new Connections();
		
		
		try
		{
	
			PreparedStatement ps = c.con.prepareStatement("insert into issues values(?,?,?)");
			ps.setString(1,email);
			ps.setString(2,mobile);
			ps.setString(3,issue);
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		

}
