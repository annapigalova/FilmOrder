<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="movietag"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film</title>
</head>
<body>

	<form method="get" action="ControllerServlet">
		<table border="0">
			<tr>
				<td><input type="text" name="film" placeholder="Search..."
					size=50 /><input type="submit" name="command" value="Search" /></td>
			</tr>
		</table>
	</form>
	<table border="0">
		<tr>
			<td>
				<form method="get" action="ControllerServlet">
					<input type="hidden" name="movieId" value="${movie.id}" /> <input
						type="hidden" name="name" value="${movie.name}" /> <input
						type="hidden" name="price" value="${movie.price}" /> <input
						type="hidden" name="url"
						value="ControllerServlet?command=show-movie-info&movieid=${movie.id}" /><input
						type="submit" name="command" value="Add to Cart" />
				</form>
			</td>
		</tr>
	</table>
	<movietag:movietable movie="${movie}" />
	<br /> Comments:
	<br />
	<c:forEach items="${movie.commentList}" var="comments">
		<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"
			value="${comments.commentDt}" />  ${comments.user.login}: 
			   ${comments.comment}
			   	<br />
	</c:forEach>

	<table border="0">
		<tr>
			<td>
				<form method="post" action="ControllerServlet">
					<input type="hidden" name="movieId" value="${movie.id}"> <input
						type="text" name="CommentText"
						placeholder="Enter your comment here"
						style="height: 25px; width: 200px" /><br /> <input type="submit"
						name="command" value="Comment" /><br /> <input type="hidden"
						name="url" value="command=show-movie-info&movieid=${movie.id}" />
				</form>
			</td>
		</tr>
	</table>
	<table border="0">
		<tr>
			<td><form method="get" action="ShoppingCart">
					<input type="submit" value="Shopping Cart" /><br />
				</form></td>
			<td><form method="get" action="MainPage">
					<input type="submit" value="Main Page" /> <br />
				</form></td>
		</tr>
	</table>
</body>
</html>