<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="basicLayout1.jsp"></jsp:include>
<br />
<br />
<br />
<br />
<center>
	<form:form action="login.htm" method="post" modelAttribute="loginBean">
		<div id="simpleBox">
			<h2 id="heading">Login with your credentials</h2>

			<c:if test="${requestScope.error != null}">
				<h4 style="color: red;">${requestScope.error}</h4>
			</c:if>
			<table id="textAlign">
				<tr>
					<td>Login ID &nbsp;&nbsp;<font color="red">*</font></td>
					<td><form:input path="loginID" class="specialTextbox" />
					<td id="loginIDAlert"><br /></td>
				</tr>
				<tr>
					<td>Password <font color="red">*</font></td>
					<td><form:password path="password" class="specialTextbox" />
					<td id="passwordAlert"></td>
				</tr>
			</table>
			<br />
			<form:checkbox path="remember" />
			Remember me. <br /> <br /> <input type="submit" value="Login"
				class="specialButton" /> <a href="adminSignUp.htm">Sign Up</a>
		</div>
	</form:form>
</center>
<br />
<br />
<br />
<br />



<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>