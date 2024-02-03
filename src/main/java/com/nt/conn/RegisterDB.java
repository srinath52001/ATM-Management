package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nt.bean.UserList_bean;


public class RegisterDB {

	String acnt_no , pin, fname,lname,email,dob, mobile,gender , user;

	public void getDatabase(String acnt_no, String pin, String fname, String lname, String email, String dob, String mobile,
			String gender, String user) throws SQLException {
		this.acnt_no = acnt_no;
		this.pin = pin;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.dob = dob;  
		this.mobile = mobile;
		this.gender = gender;
		this.user = user;
		
		try {
			Connections c = new Connections();
			PreparedStatement ps = c.con.prepareStatement("insert into register_atm values(?,?,?,?,?,?,?,?,?,atm_sql.NEXTVAL)");
			
			ps.setString(1, acnt_no);
			ps.setString(2, pin);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, email);
			ps.setString(6, dob);
			ps.setString(7, mobile);
			ps.setString(8, gender);
			ps.setString(9, user);
			ps.executeUpdate();
			
			
			PreparedStatement ps1  = c.con.prepareStatement("insert into ptransactions_atm values(?, 0)");
			ps1.setString(1, acnt_no);
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
