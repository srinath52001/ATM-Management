package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.conn.IssuesDisplaydb;

@WebServlet("/issuesdiplay")
public class issuedisplay extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		HttpSession hs = req.getSession();
		
		IssuesDisplaydb isb = new IssuesDisplaydb();
		ResultSet rs1 = isb.getissuseDisplay();
		hs.setAttribute("rsissues", rs1);

		
		RequestDispatcher rd=req.getRequestDispatcher("issues.jsp");
		rd.forward(req, resp);
	}
	
}


