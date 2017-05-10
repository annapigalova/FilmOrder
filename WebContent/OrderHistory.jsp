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
	<br />
	<br />
	 
     <c:if test="${empty orderList}">
     <c:out value="Unfortunately, you haven't made any orders yet" /> <br /><br />
     </c:if>
	<form method="get" action = "ControllerServlet">
		<c:forEach items="${orderList}" var="order">
		Order # ${order.id}<br />
			<c:forEach items="${order.movieList}" var="movie">
				<a
					href="ControllerServlet?command=show-movie-info&movieid=${movie.id}">
					${movie.name}<br />
				</a>
				<br />
			</c:forEach>
			<br />
		</c:forEach>
		 
	</form>
	
	<form method="get" action="ShoppingCart">
		<input type="submit" value="Shopping Cart" /><br />
	</form>
	
   <form method="get" action="MainPage">
         <input type="submit" value="Main Page" /> <br />
      </form>
</body>


</html>