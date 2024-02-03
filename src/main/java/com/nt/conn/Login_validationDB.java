package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login_validationDB {

	public ArrayList<String> get_validate(String id,String pass) throws SQLException {
		Connections c = new Connections();
		ArrayList<String> al = new ArrayList(); 
		
		try {
			PreparedStatement ps = c.con.prepareStatement("select * from register_atm where acct_no=? and pin=?");
			ps.setString(1, id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				al.add(rs.getString(3));
				al.add(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}
}
