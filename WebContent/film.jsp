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


		<c:out value="Name: ${movie.name}" />
		<br />
		<c:out value="Director: ${movie.director}" />
		<br />
		<c:out value="Genre: ${movie.genre}" />
		<br />
		<c:out value="Duration: ${movie.duration}" />
		<br />
		<c:out value="Description: ${movie.description}" />
		<br />
		<c:out value="Price: ${movie.price}" />
		<br /> <br /> Comments: <br />

		<c:forEach items="${movie.commentList}" var="comments"
			>
		       ${comments.user.login}: 
			   ${comments.comment}
			   	<br />
		</c:forEach>

		<input type="hidden" name="movieId" value="${movie.id}" /> <input
			type="hidden" name="name" value="${movie.name}" /> <input
			type="hidden" name="price" value="${movie.price}" /> <input
			type="submit" name="command" value="Add to Cart" />



	</form>
	<form method="post" action="ControllerServlet">
		<input type="hidden" name="movieId" value="${movie.id}"> <input
			type="text" name="CommentText" placeholder="Enter your comment here" /><br /> <input type="submit"
			name="command" value="Comment" /><br /> <input type="hidden"
			name="url" value="command=show-movie-info&movieid=${movie.id}" />
	</form>

	<form method="get" action="ShoppingCart">
		<input type="submit" value="Shopping Cart" /><br />
	</form>
	<form method="get" action="MainPage">
		<input type="submit" value="Main Page" /> <br />
	</form>


</body>
</html>