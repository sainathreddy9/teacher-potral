<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- https://stackoverflow.com/questions/33152127/how-to-pass-checkbox-values-to-the-controller-in-spring-mvc -->
<jsp:include page="basicLayout1.jsp"></jsp:include>

<br />
<center>
	<div class="divBox">
		<h3 style="color: maroon;">Class Attendance</h3>
		<c:if test="${requestScope.results != null}">
			<h4 style="color: red;">${requestScope.results}</h4>
		</c:if>
		<c:if test="${requestScope.error1 != null}">
			<h4 style="color: red;">Hello${requestScope.error1}</h4>
		</c:if>

		<table border="0" class="tableStyle">

			<form:form action="loadStudents.htm" name="sForm"
				modelAttribute="classDetails" onsubmit="validateSignUP()">
				<tr>
					<td>Class <font color="red">*</font></td>
					<td><form:select path="classId" class="specialTextbox"
							id="classId">
							<form:option value="" label="--Select Class--" />
							<form:option value="5" label="5" />
							<form:option value="6" label="6" />
							<form:option value="7" label="7" />
							<form:option value="8" label="8" />
							<form:option value="9" label="9" />
							<form:option value="10" label="10" />
						</form:select>
					<td id="errClassId"><form:errors path="classId"
							cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Section <font color="red">*</font></td>
					<td><form:input type="number" value="1" min="1" max="2"
							path="semester" class="specialTextbox" id="fullName"
							onblur="validateSemester()" onfocus="fullSemester()" size="15" /></td>
					<td id="errSemester" style="color: red"><form:errors
							path="semester" /></td>
				</tr>
				<tr>
					<td>Date <font color="red">*</font></td>
					<td><input type="date" name="attenDate" class="specialTextbox"
						id="attenDate" value="${classDetails.attenDate}" onblur="validateDoc()"
						size="38" /></td>
					</td>
					<td id="errAttenDate" style="color: red"><form:errors
							path="attenDate" /></td>
				</tr>
				<%
					String teacher_id = (String) request.getSession().getAttribute("teacher_id");
				%>
				<input id="teacher_id" name="teacher_id" type="hidden"
					value="<%=teacher_id%>" />
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Attendance" class="specialButton" /> <a href="home.htm"
						class="buttonLink"><button class="specialButton">Back</button></a>

					</td>
				</tr>
			</form:form>
		</table>
	</div>
</center>





<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>
