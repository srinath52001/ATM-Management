package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBlnceDB {

	public String viewBlnce(String acntNo) {

		String tsum = "";
		Connections c = new Connections();
		try {
			PreparedStatement ps = c.con.prepareStatement("select tsum from ptransactions_atm where account_no=?");
			  ps.setString(1,acntNo);
			  ResultSet rs = ps.executeQuery();
			  if(rs.next())
			  {
				 tsum = rs.getString(1);
			  }
			  return tsum;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tsum;
		
	}

}
