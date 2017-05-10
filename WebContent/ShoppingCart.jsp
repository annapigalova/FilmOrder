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
      <c:forEach var="movieList" items="${sessionScope.movieList}">
         <tr>
            <td>
               <c:out value="${movieList.name}" />
            </td>
            <td>
               <c:out value="${movieList.price}" />
            </td>
         </tr>
      </c:forEach>
      <c:choose>
         <c:when test="${sessionScope.movieList != null}">
            <form method="get" action="ControllerServlet">
               <input type="submit" name="command" value="Order History" /> <br />
               <input type="submit" name="command" value="Pay Order" /><br />
            </form>
            <form method="get" action="MainPage">
               <input type="submit" value="Main Page" /> <br />
            </form>
         </c:when>
         <c:otherwise>
            <form method="get" action="ControllerServlet">
               <input type="submit" name="command" value="Order History" /> <br />
            </form>
            <form method="get" action="MainPage">
               <input type="submit" value="Main Page" /> <br />
            </form>
            <h3>Your cart is empty!</h3>
         </c:otherwise>
      </c:choose>
   </body>
</html>