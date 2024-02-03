package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.conn.Login_validationDB;


@WebServlet("/loginvalidate")
public class Login_validate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acnt_no  = request.getParameter("acnt_no");
		String pass	    = request.getParameter("pass");
		PrintWriter pw = response.getWriter();
		
		if(acnt_no.length() == 0 || pass.length()==0) {
			pw.print("<html><body><center style='color:red;'><form><div class='bk'>");
			pw.print("Enter login credentials");
			pw.print("</div></form></center></body></html>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		else
		{
			
			
			try {
				Login_validationDB lv = new Login_validationDB();
				ArrayList<String > al = lv.get_validate(acnt_no, pass);
				
				if(al.size() !=0) {
				HttpSession hs  = request.getSession();
				hs.setAttribute("username",al.get(0));
				hs.setAttribute("acntNo",acnt_no);
				
				if(al.get(1).equals("admin")) {
					RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
					rd.forward(request, response);
				}else if(al.get(1).equals("user")) {
					RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
					rd.forward(request, response);
				}
				}
				else
				{
					pw.print("<html><body><center style='color:red;'><form><div class='bk'>");
					pw.print("Incorrect Password");
					pw.print("</div></form></center></body></html>");
					request.getRequestDispatcher("login.html").include(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
