package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssuesDisplaydb {

	ResultSet rs;
	public ResultSet getissuseDisplay() {
		
		Connections c  = new Connections();
		
		try
		{
			
			PreparedStatement ps   = c.con.prepareStatement("select * from issues");
			rs = ps.executeQuery();
			System.out.println(rs);

			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

}
