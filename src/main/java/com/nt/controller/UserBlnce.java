package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.conn.UserBlnceDB;

@WebServlet("/UserBlnce")
public class UserBlnce extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		UserBlnceDB udb = new UserBlnceDB();
		HttpSession hs = request.getSession();
		String acntNo = (String)hs.getAttribute("acntNo");
		
		
		String tsum = udb.viewBlnce(acntNo);
		hs.setAttribute("tsum", tsum);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
