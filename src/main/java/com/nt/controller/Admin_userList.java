package com.nt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bean.UserList_bean;
import com.nt.conn.Admin_userList_db;

@WebServlet("/Adminuserlist")
public class Admin_userList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
	
			Admin_userList_db adm = new Admin_userList_db();
			UserList_bean ulb = adm.adminController();
			request.setAttribute("adminUserList", ulb);
			RequestDispatcher rd = request.getRequestDispatcher("AdminViewUserList.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
