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
import com.nt.conn.AdminUserListDeleteDB;


@WebServlet("/AdminUserListDelete")
public class AdminUserListDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actNo = (request.getParameter("acnt_no"));
		
		AdminUserListDeleteDB adb = new AdminUserListDeleteDB();
		try {
			adb.deleteRow(actNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		UserList_bean ul = new UserList_bean();
		
//		
//		int n = ul.al.size(),i=0;
//		
//		while(i>n) {
//			
//			if(actNo.equals(ul.al.get(i).get(9))) {
//				ul.al.remove(i);
//			}
//			i++;
//		}
		
		response.sendRedirect("Adminuserlist");
//		RequestDispatcher rd = request.getRequestDispatcher("AdminViewUserList.jsp");
//		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
