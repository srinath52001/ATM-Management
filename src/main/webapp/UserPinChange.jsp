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
		.si{
			background-color:black;
			color:white;
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
			&nbsp;&nbsp;<a href="ViewBlnce.jsp">View Balance</a>
			&nbsp;&nbsp;<a href="deposit.jsp">Deposit Cash</a>
			&nbsp;&nbsp;<a href="withdraw.jsp">Withdraw Cash</a>
			&nbsp;&nbsp;<a href="UserMiniStatement.jsp">Mini Statement</a>
			&nbsp;&nbsp;<a style="padding-left:800px;" href="user.jsp">Hi, Test(<%HttpSession hs = request.getSession(); out.print(hs.getAttribute("username")); %>)</a>
			&nbsp;&nbsp;<a href="UserPinChange.jsp">ChangePin</a>
			&nbsp;&nbsp;<a href="login.html">LogOut</a>
		
		
		</div>
		
		<form action="UserPinChange" method="post>">
			<center>
		<div class="bk">	
			<div class="t2">
				<h1>Change Pin!</h1>
			</div>
			
			<div class="d">
				<table class="tr">
					<tr><td>Enter Old Pin</td></tr>
					<tr ><td><input type="text"  name="oldPin"  style="width: 450px; height: 30px;  "></td></tr>
					<tr><td>Enter New Pin</td></tr>
					<tr ><td><input type="text"  name="newPin"  style="width: 450px; height: 30px;  "></td></tr>
					<tr ><td><input class="si" type="submit" value="Change Pin"  style="width: 450px; height: 30px; border-radius: 1em 1em 1em 1em; "></td></tr>
				</table>
			</div>
		</div>
		</center>
		</form>
</body>
</html>