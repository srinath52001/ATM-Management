<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


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
		
		
	
</style>


</head>
<body>
<h2>ATM MANAGEMENT</h2>

		
		<div class="t">
			<a href="welcome.html">Home</a>
			&nbsp;&nbsp;<a href="ViewBlnce.jsp">View Balance</a>
			&nbsp;&nbsp;<a href="deposit.jsp">Deposit Cash</a>
			&nbsp;&nbsp;<a href="withdraw.jsp">Withdraw Cash</a>
			&nbsp;&nbsp;<a href="UserMiniStatement.jsp">Mini Statement</a>
			&nbsp;&nbsp;<a style="padding-left:800px;" href="user.jsp">Hi, Test(<%HttpSession hs = request.getSession(); out.print(hs.getAttribute("username")); %>)</a>
			&nbsp;&nbsp;<a href="UserPinChange.jsp">ChangePin</a>
			&nbsp;&nbsp;<a href="login.html">LogOut</a>
			
		</div>
			<center>
		<div class="t2">
			<h1>Welcome To ATM Management</h1>
		</div>
			<span><i>It allows users to perform self-service transactions and balance enquires</i></span>
		</center>

</body>
</html>