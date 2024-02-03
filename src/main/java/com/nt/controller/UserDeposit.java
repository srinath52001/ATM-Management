package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.conn.UserDeposit_db;

@WebServlet("/UserDeposit")
public class UserDeposit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		int n = Integer.parseInt(request.getParameter("amt"));
		
		if(n!=0) 
		{
		HttpSession hs = request.getSession();
		String acnt_no = (String)hs.getAttribute("acntNo");
		String userName = (String) hs.getAttribute("username");
		UserDeposit_db udb = new UserDeposit_db();
		try {
			udb.userdeposit(n,acnt_no,userName);
			pw.print("<html><body><center style='color:Green;'><form><div class='bk'>");
			pw.print("Amount has been Credited");
			pw.print("</div></form></center></body></html>");
			request.getRequestDispatcher("deposit.jsp").include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		else
		{
			pw.print("<html><body><center style='color:red;'><form><div class='bk'>");
			pw.print("Please enter the Amount");
			pw.print("</div></form></center></body></html>");
			request.getRequestDispatcher("deposit.jsp").include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
