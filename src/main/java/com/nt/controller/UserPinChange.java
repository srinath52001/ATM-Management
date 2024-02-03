package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.conn.UserPinChangeDB;

@WebServlet("/UserPinChange")
public class UserPinChange extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		String oldPin = request.getParameter("oldPin");
		String newPin = request.getParameter("newPin");
		HttpSession hs = request.getSession();
		String acntNo = (String)hs.getAttribute("acntNo");
		
		
		
		
		UserPinChangeDB updb = new UserPinChangeDB();
		String b  =updb.getUserPinChange(acntNo,oldPin,newPin);
		if(b.equals("admin")) 
		{
			pw.print("<html><body><center style='color:Green;'><form><div class='bk'>");
			pw.print("your pin has been changed");
			pw.print("</div></form></center></body></html>");
			request.getRequestDispatcher("AdminPinChange.jsp").include(request, response);	
		}
		else if(b.equals("user"))
		{
			pw.print("<html><body><center style='color:Green;'><form><div class='bk'>");
			pw.print("your pin has been changed");
			pw.print("</div></form></center></body></html>");
			request.getRequestDispatcher("UserPinChange.jsp").include(request, response);
		}
		else if(b.equals("adminf"))
		{
			pw.print("<html><body><center style='color:red;'><form><div class='bk'>");
			pw.print("your old pin is not matching");
			pw.print("</div></form></center></body></html>");
			request.getRequestDispatcher("AdminPinChange.jsp").include(request, response);
		}
		else {
			pw.print("<html><body><center style='color:red;'><form><div class='bk'>");
			pw.print("your old pin is not matching");
			pw.print("</div></form></center></body></html>");
			request.getRequestDispatcher("UserPinChange.jsp").include(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
