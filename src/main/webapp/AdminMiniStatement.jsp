<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


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
			padding:30px;
			font-size:35px;	
		}
		.span{
		padding:10px;
		}
		.table{
				width:80%;
			 	text-align: center;
				margin:30px auto 0px auto;
				height:250px;
				font-size:18px;
		}
		.bk{
			width:75%;
			box-shadow:	5px 5px 5px 5px #888888;
			background-color:#F8F8FF;
			padding-bottom:20px;	
		}
		
		
	
</style>


</head>
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
		
		
		<center>
		<div class="bk">
			<h1 class="t2">Mini Statement!</h1><br>
		<%
			ResultSet rs  =(ResultSet)request.getAttribute("rs2");
		%>
		
		<% if(rs.next())
			{
		%>
		<table class="table" border="1px">
				<tr style="background-color:lightgreen;">
					<th>Account No</th>
					<th>Account Holder Name</th>
					<th>Amount</th>
					<th>Transaction_Type</th>
					<th>Amount Total</th>
					<th>Time & Date</th>
				</tr>
				<%
				rs.beforeFirst();
				while(rs.next())
				{ 
				%>
			<tr style="background-color:#F5FFFA;">
					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(4)%></td>
					<td><%=rs.getString(5)%></td>
					<td><%=rs.getString(6)%></td>
				</tr>
				<% } %>
		</table>
		<% } 
		else
		{
		%>
		<h2>No data Found</h2>
		<%} %>
		
		<a href="AdminViewTransactions" style="color:violet">Back</a>
		</div>
	</center>
		

<body>


</body>
</html>