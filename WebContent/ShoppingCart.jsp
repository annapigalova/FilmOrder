<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShoppingCart</title>
</head>
<body>
	<table style="width: 20%">
		<tr>
			<th align="left">Movie</th>
			<th align="left">Price</th>
			<c:set var="total" value="${0}" />
			<c:forEach var="movieList" items="${sessionScope.cart.movieList}">

				<tr>
					<td><c:out value="${movieList.name}" /></td>
					<td><c:out value="${movieList.price}" /></td>
				</tr>
				<c:set var="total" value="${total + movieList.price}" />
			</c:forEach>
		<tr>
			<td></td>
			<td><c:out value="${total}" /></td>
		</tr>
	</table>
	<c:choose>
		<c:when test="${sessionScope.cart.movieList != null}">
			<table>
				<tr>
					<td>
						<form method="post" action="ControllerServlet">
							<input type="submit" style="height: 20px; width: 150px"
								name="command" value="Pay Order" /><br />
						</form>
					</td>

					<td>
						<form method="get" action="ControllerServlet">
							<input type="submit" style="height: 20px; width: 150px"
								name="command" value="Order History" /> <br />

						</form>
					</td>

					<td>
						<form method="get" action="MainPage">
							<input type="submit" style="height: 20px; width: 150px"
								value="Main Page" /> <br />
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<td>
						<form method="get" action="ControllerServlet">
							<input type="submit" style="height: 20px; width: 150px"
								name="command" value="Order History" /> <br />
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form method="get" action="MainPage">
							<input type="submit" style="height: 20px; width: 150px"
								value="Main Page" /> <br />
						</form>
					</td>
				</tr>
				<tr>
					<td>Your cart is empty!</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>