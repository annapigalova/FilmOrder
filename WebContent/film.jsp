<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film</title>
</head>
<body>
	<form method="get" action="ControllerServlet">
		<c:out value="Name ${movie.name}" />
		<c:out value="Director ${movie.director}" />
		<c:out value="Genre ${movie.genre}" />
		<c:out value="Duration ${movie.duration}" />
		<c:out value="Description ${movie.description}" />
		<c:out value="Description ${movie.price}" />
		<input type="hidden" name="movieId" value="${movie.id}" /> <input
			type="hidden" name="name" value="${movie.name}" /> <input
			type="hidden" name="price" value="${movie.price}" /> <input
			type="submit" name="command" value="Add to Cart" />



	</form>
		<form method="post" action="ControllerServlet">
		<input type = "hidden" name = "movieId" value ="${movie.id}"  >
		<input type="text" name="CommentText" /><br />
		<input type="submit" name = "command" value="Comment" /><br />
	</form>

	<form method="get" action="ShoppingCart">
		<input type="submit" value="Shopping Cart" /><br />
	</form>
	<form method="get" action="MainPage">
		<input type="submit" value="Main Page" /> <br />
	</form>
</body>
</html>