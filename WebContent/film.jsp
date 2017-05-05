<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film</title>
</head>
<body>
	Name:
	<input type="text" name="name" />
	<br /> Year:
	<input type="text" name="year" />
	<br /> Director:
	<input type="text" name="director" />
	<br /> Duration min:
	<input type="text" name="duration" />
	<br /> Genre:
	<input type="text" name="genre" />
	<br /> Price:
	<input type="text" name="price" />
	<br /> Description:
	<input type="text" name="description" />
	<br />
	<input type="submit" value="add to cart" />
	<form method="post" action="ShoppingCart.jsp">
		<input type="submit" value="Your Shopping Cart" /><br />
	</form>
</body>
</html>