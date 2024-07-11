<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>


<jsp:include page="basicLayout1.jsp"></jsp:include>

<center>
	<br /> <br /> <br /> <br />
	<h2>Student created successfully!</h2>

	<h5>
		Student ID is :<i style="color: red">${requestScope.id}</i>
	</h5>

	<br /> <br /> <br /> <br />
</center>

<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>