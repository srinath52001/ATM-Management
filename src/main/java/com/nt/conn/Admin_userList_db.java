package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nt.bean.UserList_bean;

public class Admin_userList_db {
	Connections c = new Connections();
	
	
	UserList_bean ub ;

	public UserList_bean adminController() throws SQLException {
		
		
	try {
		PreparedStatement ps = c.con.prepareStatement("select * from register_atm where role='user'");
		ResultSet rs   = ps.executeQuery();
		
		ub = new UserList_bean();
		
		
		if(rs!=null)
		{
			while(rs.next())
			{
				String acnt  = rs.getString(1);
				String pin  = rs.getString(2);
				String fname  = rs.getString(3);
				String lname  = rs.getString(4);
				String mail  = rs.getString(5);
				String dob  = rs.getString(6);
				String mbl  = rs.getString(7);
				String gender  = rs.getString(8);
				String role  = rs.getString(9);
				int id  = rs.getInt(10);
				
				ub.setAcnt_no(acnt);
				ub.setPin(pin);
				ub.setFname(fname);
				ub.setLname(lname);
				ub.setEmail(mail);
				ub.setDob(dob);
				ub.setMobile(mbl);
				ub.setGender(gender);
				ub.setUser(role);
				ub.setId(id);
								
				ub.getArraylist();
			}
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ub;
	}
}
