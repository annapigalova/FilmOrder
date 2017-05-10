<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MainPage</title>
</head>
<body>
	<form method="get" action="ControllerServlet">
		Search Films:<input type="text" name="film" /> <input type="submit"
			name="command" value="Search" /><br /> <input type="submit"
			name="command" value="Order History" /> <br />

	</form>

	<form method="get" action="ShoppingCart">
		<input type="submit" value="Shopping Cart" /><br />
	</form>
</body>
</html>
