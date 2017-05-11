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
		<table border="0">
			<tr>
				<td><input type="text" name="film" placeholder="Search..."
					size=50 /><input type="submit" name="command" value="Search" /></td>

			</tr>
			<tr>
				<td><input type="submit" name="command" value="Order History"
					style="height: 22px; width: 150px" /></td>
			</tr>
		</table>
	</form>
	<form method="get" action="ShoppingCart">
		<table border="0">

			<tr>
				<td><input type="submit" value="Shopping Cart"
					style="height: 22px; width: 150px" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
