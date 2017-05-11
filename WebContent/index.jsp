<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CinemaWorld</title>
</head>
<body>
	<h1>Welcome to Cinema World!</h1>

	<form method="post" action="ControllerServlet">
		<input type="text" name="login" placeholder="LogIn" /><br /> <input
			type="password" name="password" placeholder="Password" /><br /> <input
			type="submit" name="command" value="Login" />
	</form>
	
	<form method="get" action="Register">
		<a href="Register">Register</a>
	</form>


</body>
</html>