package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.conn.UserMiniStatementDB;


@WebServlet("/AdminTransactionList")
public class AdminTransactionList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();

		UserMiniStatementDB uatdb = new UserMiniStatementDB();
		
		String act_no = request.getParameter("acnt_no");
		
		
		ResultSet rs = uatdb.getUserMiniStatement(act_no);
		request.setAttribute("rs2", rs);
		RequestDispatcher rd = request.getRequestDispatcher("AdminMiniStatement.jsp");
		rd.forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
