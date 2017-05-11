<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>

<body>

	<c:out value="Hello, ${user.login}" />
	<c:if test="${empty orderList}">
		<c:out value="Unfortunately, you haven't made any orders yet" />
	</c:if>
	<table>
		<tr>
			<td>
				<form method="get" action="ShoppingCart">
					<input type="submit" value="Shopping Cart" /><br />
				</form>
			</td>
			<td>
				<form method="get" action="MainPage">
					<input type="submit" value="Main Page" /> <br />
				</form>
			</td>
		</tr>
	</table>

	<table>

		<form method="get" action="ControllerServlet">
			<c:forEach items="${orderList}" var="order">
				<tr>
					<td>Order # ${order.id}</td>
				<tr>

					<c:forEach items="${order.movieList}" var="movie">
						<tr>
							<td><a
								href="ControllerServlet?command=show-movie-info&movieid=${movie.id}">
									${movie.name} </a></td>
						</tr>

					</c:forEach>
			</c:forEach>
		</form>
	</table>
</body>

</html>