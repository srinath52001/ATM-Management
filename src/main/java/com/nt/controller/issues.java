package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.conn.Issues_db;


@WebServlet("/issues")
public class issues extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		String email = req.getParameter("email");
		String mobile = req.getParameter("mbl");
		String issue = req.getParameter("eissue");
		
		
		if(email.length()==0 || mobile.length()==0 || issue.length()==0)
		{
			pw.print("<html><body><h1 style='color:red'>please enter the issue properly</h1></body></html>");
			req.getRequestDispatcher("issues.html").include(req, resp);
		}	
		else
		{
			Issues_db isdb = new Issues_db();
			isdb.getIssues(email,mobile,issue);
			pw.print("<html><body><h1 style='color:green'>issue is registered & will get solved</h1></body></html>");
			req.getRequestDispatcher("register.html").include(req, resp);
		}	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
