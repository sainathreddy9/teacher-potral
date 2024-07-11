<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- https://stackoverflow.com/questions/33152127/how-to-pass-checkbox-values-to-the-controller-in-spring-mvc -->
<jsp:include page="basicLayout1.jsp"></jsp:include>

<br />
<center>
	<div class="divBox1">
		<h3 style="color: maroon;">Time Table</h3>

		<c:if test="${requestScope.error1 != null}">
			<h4 style="color: red;">${requestScope.error1}</h4>
		</c:if>

		<table border="0" class="tableStyle">

			<form:form name="sForm" modelAttribute="timetableDetails">

				<tr>
					<td>Class :</td>
					<td><b>${timetableDetails.classId}</b></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>Section : </font></td>
					<td><b>${timetableDetails.semester}</b></td>
				</tr>
				<tr>
					<table border="1">
						<tr>
							<th>Day/Time</th>
							<th>8.30 - 9.30</th>
							<th>9.30 - 10.30</th>
							<th>10.30 - 11.30</th>
							<th>11.30 - 12.30</th>
							<th>12.30 - 1.30</th>
							<th>1.30 - 2.30</th>
							<th>2.30 - 3.30</th>
						</tr>
						<% int count=0; %>
						<c:if test="${timetableDetails.timeTableDetails.size() == 0 }">
							<tr>
								<td colspan="7" align="center"><font color="red">No
										Time table configured.</font></td>
							</tr>
						</c:if>
						<c:forEach var="item" items="${timetableDetails.timeTableDetails}">
							<tr>
								<td>${item.day}</td>
								<td>${item.period1}</td>
								<td>${item.period2}</td>
								<td>${item.period3}</td>
								<td>${item.period4}</td>
								<% if(count == 0){ %>
    							<td rowspan="${timetableDetails.timeTableDetails.size()}"><p>   BREAK LUNCH </p></td>
    							<% } %>
								<td>${item.period5}</td>
								<td>${item.period6}</td>
							</tr>
							<% count++; %>
						</c:forEach>
					</table>
				</tr>

				<%
					String teacher_id = (String) request.getSession().getAttribute("teacher_id");
				%>
				<input id="teacherId" name="teacherId" type="hidden"
					value="<%=teacher_id%>" />
				<br>
				<tr>
					<td colspan="3" align="center">
			</form:form>
			<a href="viewTimeTable.htm" class="buttonLink"><button
					class="specialButton">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Back</button></a>
			</td>
			</tr>
			<br>
			<br>
		</table>
	</div>
</center>





<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>
