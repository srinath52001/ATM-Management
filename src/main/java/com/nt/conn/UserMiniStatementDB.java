package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMiniStatementDB {

	
	ResultSet rs;
	public ResultSet getUserMiniStatement(String acntNo) {
		
		Connections c = new Connections(); 
		
		try {
			PreparedStatement ps = c.con.prepareStatement("select * from transactions_atm where account_no=?",ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			  ps.setString(1,acntNo);
			  rs = ps.executeQuery();
			  return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
}
