package com.nt.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.conn.UserMiniStatementDB;


@WebServlet("/UserMiniStatement")
public class UserMiniStatement extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserMiniStatementDB umdb = new UserMiniStatementDB();
		HttpSession hs = request.getSession();
		String acntNo = (String)hs.getAttribute("acntNo");
		
		
		
		ResultSet rs = umdb.getUserMiniStatement(acntNo);
		hs.setAttribute("rs", rs);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
