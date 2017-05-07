<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<form method="post" action="ControllerServlet">
		Login:<input type="text" name="login" /><br /> Password:<input
			type="text" name="password" /><br /> First Name:<input type="text"
			name="firstName" /><br /> Last Name:<input type="text"
			name="lastName" /><br /> Email:<input type="text" name="email" /><br />
		Phone Number:<input type="text" name="phoneNum" /><br /> <input
			type="submit" name="command" value="Register" />
	</form>
</body>
</html>