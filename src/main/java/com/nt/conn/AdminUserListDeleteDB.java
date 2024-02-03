package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminUserListDeleteDB {
	
	
	public void deleteRow(String actNo) throws SQLException {
	Connections c = new Connections();
	PreparedStatement ps = c.con.prepareStatement("delete from register_atm where acct_no=?");
	ps.setString(1,actNo);
	ps.executeUpdate();
	return;
	}
}
