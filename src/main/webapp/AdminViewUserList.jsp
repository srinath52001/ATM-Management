<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.nt.bean.UserList_bean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<style>
			*{
		margin:0px;
		padding:0px;
		}

			h2{
			background-color:darkgreen;
			height:30px;
			padding:20px 10px;
		}
		.t{
			background-color:black;
			height:23px;
			padding:5px 10px;
		}
		a{
			color:white;
			text-decoration:none;
		}
		
		.t2{
			padding:50px;
			font-size:30px;	
		}
		.span{
		padding:10px;
		}
		.table{
				width:56%;
			 	text-align: center;
				margin-left:auto;
				margin-right:auto;
				height:200px;
		}
		
		
		
	
</style>

<body>
<h2>ATM MANAGEMENT</h2>

				
		<div class="t">
			<a href="welcome.html">Home</a>
			&nbsp;&nbsp;<a href="Adminuserlist">UserList</a>
			&nbsp;&nbsp;<a href="AdminViewTransactions">TransactionList</a>
			&nbsp;&nbsp;<a href="issuesdiplay">Issues</a>
			&nbsp;&nbsp;<a style="padding-left:910px;" href="">Hi, Admin(<%HttpSession hs = request.getSession(); out.print(hs.getAttribute("username")); %>)</a>
			&nbsp;&nbsp;<a href="AdminPinChange.jsp">ChangePin</a>
			&nbsp;&nbsp;<a href="login.html">LogOut</a>
			
		</div>
			


<%
	UserList_bean usb = (UserList_bean)request.getAttribute("adminUserList");
	int n = usb.al.size();
	
	if(n!=0)
	{	
%>
<br><br><br>

<table class="table" border="1px">

	<tr style="background-color:lightgreen;">
	<th>Account_no</th>
	<th>Name</th>
	<th>Email</th>
	<th>Date Of Birth</th>
	<th>Mobile</th>
	<th>Gender</th>
	<th>Delete</th>
	</tr>
	
	<%	
		for(int i=0;i<usb.al.size();i++)
		{
			int id  = (int)usb.al.get(i).get(9);
	%>
	<tr>
		<td><%=(String)usb.al.get(i).get(0) %></td>
		<td><%=(String)usb.al.get(i).get(2)+usb.al.get(i).get(3) %></td>
		<td><%=(String)usb.al.get(i).get(4) %></td>
		<td><%=(String)usb.al.get(i).get(5) %></td>
		<td><%=(String)usb.al.get(i).get(6) %></td>
		<td><%=(String)usb.al.get(i).get(7) %></td>
		<td><a style="color:red;" href="AdminUserListDelete?acnt_no=<%= (String)usb.al.get(i).get(0)%>">Delete</a></td>		
	</tr>
	<%
	}
	%>
</table>

<% }  %>


</body>
</html>