<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="basicLayout1.jsp"></jsp:include>

<center>
	<c:if test="${requestScope.error != null}">
		<h4 style="color: red;">${requestScope.error}</h4>
	</c:if>

	<br />
	<form action="home.htm" method="post">
		<input type="submit" Value="Back to Home" class="specialButton" />
	</form>
</center>

<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>