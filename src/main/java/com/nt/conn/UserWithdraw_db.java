package com.nt.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserWithdraw_db {

	
public void userWithdraw(int amt,String acnt_no,String userName) throws SQLException {
		
		int tbal=0;
		String tsum="";
		
		Connections c = new Connections();
		
		
		
		try {
			
			PreparedStatement ps = c.con.prepareStatement("select tsum from ptransactions_atm where account_no=?");
			ps.setString(1, acnt_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				tsum = rs.getString(1);
			}
			tbal = Integer.parseInt(tsum)-amt;
			
			
			PreparedStatement ps1 = c.con.prepareStatement("insert into transactions_atm values (?,?,?,?,?,to_char(sysdate,'dd-mm-yy hh24:mi:ss'))");
			ps1.setString(1, acnt_no);
			ps1.setString(2,userName);
			ps1.setInt(3, amt);
			ps1.setString(4,"Withdraw");
			ps1.setInt(5, tbal);
			ps1.executeUpdate();
			
			
			PreparedStatement ps2 = c.con.prepareStatement("update ptransactions_atm set tsum =? where account_no=?");
			ps2.setInt(1,tbal);
			ps2.setString(2, acnt_no);
			ps2.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
