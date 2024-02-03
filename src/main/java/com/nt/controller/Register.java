package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.conn.RegisterDB;

@WebServlet("/register")
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String acnt_no = request.getParameter("actno");
		String pin = request.getParameter("pin");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String mobile = request.getParameter("m");
		String gender = request.getParameter("gender");
		String user = "user";
		
		
		if (acnt_no.length() == 0 || pin.length() == 0 || fname.length() == 0 || lname.length() == 0
				|| email.length() == 0 || dob.length() == 0 || mobile.length() == 0 || gender.length() == 0)
		{
			pw.print("<html><body><center style='color:red;'><form><div class='bk'>");
			pw.print("Fill all details");
			pw.print("</div></form></center></body></html>");
			request.getRequestDispatcher("register.html").include(request, response);
		}
		else {
		if (gender.equals("male")) 
		{
			gender = "male";
		} else
		{
			gender = "female";
		}
		RegisterDB db  = new RegisterDB();
		try {
			db.getDatabase(acnt_no, pin, fname, lname, email, dob, mobile, gender, user);
			pw.print("<html><body><center>Registration Sucessfull</center></body></html>");
			request.getRequestDispatcher("register.html").include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 finally {
			pw.close();
		}
		
	}
		
		
		
//
//		Connections c = new Connections();
//		if (acnt_no.length() == 0 || pin.length() == 0 || fname.length() == 0 || lname.length() == 0
//				|| email.length() == 0 || dob.length() == 0 || mobile.length() == 0 || gender.length() == 0) {
				
//		} else {
//			try {
//				PreparedStatement ps = c.con.prepareStatement("insert into register_atm values(?,?,?,?,?,?,?,?,atm_sql.NEXTVAL,?)");
//
//				ps.setString(1, acnt_no);
//				ps.setString(2, pin);
//				ps.setString(3, fname);
//				ps.setString(4, lname);
//				ps.setString(5, email);
//				ps.setString(6, dob);
//				ps.setString(7, mobile);
//				ps.setString(8, gender);
//				ps.setString(9, user);
//				ps.executeUpdate();
				
//			} catch (SQLException e) {
//				e.printStackTrace();
			
//			
//
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
