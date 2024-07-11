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

		<c:if test="${requestScope.error1 != null}">
			<h4 style="color: red;">${requestScope.error1}</h4>
		</c:if>

		${studentsList.studentName}
		<table border="0" class="tableStyle">

			<form:form action="createAttendance.htm" name="sForm"
				modelAttribute="classDetails" onsubmit="validateSignUP()">

				<tr>
					<td>Class &nbsp;&nbsp;&nbsp;<font color="red">*</font></td>
					<td><form:select path="classId" class="specialTextbox"
							id="classId" readonly="true">
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
					<td><form:input type="number" min="1" max="8" path="semester"
							class="specialTextbox" id="fullName" onblur="validateSemester()"
							onfocus="fullSemester()" size="15" readonly="true" /></td>
					<td id="errSemester" style="color: red"><form:errors
							path="semester" /></td>
				</tr>

				<tr>
					<td>Date &nbsp;&nbsp;&nbsp;<font color="red">*</font></td>
					<td><input type="date" name="attenDate" class="specialTextbox"
						id="attenDate" onfocus="docClear()" onblur="validateDoc()"
						size="38" readonly="true" value="${classDetails.attenDate}" min ="2019-10-01" max ="2019-11-01"/></td>
					</td>
					<td id="errAttenDate" style="color: red"><form:errors
							path="attenDate" /></td>
				</tr>

				<tr>
					<table border="1" width="90%">
						<tr>
							<th>USN</th>
							<th>Student Name</th>
							<th>Attendance</th>
						</tr>
						<c:if test="${classDetails.studentsList.size() == 0 }">
						<tr><td colspan="3" align="center"><font color="red">No students available in this Class</font></td></tr>
						</c:if>
						<c:forEach var="item" items="${classDetails.studentsList}">
							<tr>
								<td>${item.usn}</td>
								<td>${item.studentName}</td>
								<td><span class="checkbox"> <c:if
											test="${item.status == 'Y'}">
											<form:checkbox path="studentIdsList"
												value="${item.studentId}" id="${item.studentId}"
												disabled="false" /></span></td>
								</c:if>
								<c:if test="${item.status == 'N'}">
									<form:checkbox path="studentIdsList" value="${item.studentId}"
										id="${item.studentId}" disabled="false" />
									</span>
									</td>
									<script>
										document
												.getElementById("${item.studentId}").checked = false;
									</script>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</tr>

				<%
					String teacher_id = (String) request.getSession().getAttribute("teacher_id");
				%>
				<input id="teacherId" name="teacherId" type="hidden"
					value="<%=teacher_id%>" />
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save Attendance" class="specialButton" />
			</form:form>
			<a href="home.htm" class="buttonLink"><button
					class="specialButton">Back</button></a>
			</td>
			</tr>

		</table>
	</div>
</center>





<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>
