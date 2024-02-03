package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPinChangeDB {

	public String getUserPinChange(String acntNo,String oldPin,String newPin) {
		
		
		String role="";
		Connections c = new Connections();
		try {
			PreparedStatement ps1 = c.con.prepareStatement("select pin,role from register_atm where acct_no=?");
			ps1.setString(1, acntNo);
			ResultSet rs  =  ps1.executeQuery();
			if(rs.next() )
			{
				String pin= rs.getString(1);
				role   = rs.getString(2);
				if(pin.equals(oldPin))
				{	
					PreparedStatement ps = c.con.prepareStatement("update register_atm set pin=? where acct_no=?");
					ps.setString(1, newPin);
					ps.setString(2,acntNo);
					ps.executeUpdate();
					return role;
				}
			}
			else {
				PreparedStatement ps2 = c.con.prepareStatement("select role from register_atm where acct_no=?");
				ps2.setString(1, acntNo);
				ResultSet rs1  =  ps1.executeQuery();
				if(rs1.next()){
					role = rs1.getString(1);
					return role;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role+'f';
	}
	
}
