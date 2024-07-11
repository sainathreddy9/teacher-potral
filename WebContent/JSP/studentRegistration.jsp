<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="basicLayout1.jsp"></jsp:include>

<center>
	<h2>APPLICATION FORM</h2>
	<%-- <c:url var="myAction" value="checkForm.htm" /> --%>
	<c:if test="${requestScope.error1 != null}">
		<h4 style="color: red;">${requestScope.error1}</h4>
	</c:if>
	<table class="tableStyle">
		<form:form action="createStudent.htm" name="studentForm"
			modelAttribute="studentDetails" onsubmit="validateStudentDetails()">
			<tr>
				<td>USN <font color="red">*</font></td>
				<td><form:input path="usn" class="specialTextbox" id="usn"
						onblur="validateUsn()" onfocus="usnClear()" size="38" /></td>
				<td id="errUsn" style="color: red"><form:errors path="usn"
						cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Student Name <font color="red">*</font></td>
				<td><form:input path="fullName" class="specialTextbox"
						id="fullName" onblur="validateFullName()"
						onfocus="fullNameClear()" size="38" /></td>
				<td id="errFullName" style="color: red"><form:errors
						path="fullName" /></td>
			</tr>
			<tr>
				<td>Date of birth <font color="red">*</font></td>
				<td><input type="date" name="dateOfBirth"
					class="specialTextbox" id="dateOfBirth" onfocus="dobClear()"
					onblur="validateDob()" size="38" /></td>
				<td id="errDob"><form:errors path="dateOfBirth"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Class <font color="red">*</font></td>
				<td><form:select path="department" class="specialTextbox"
						id="department" onblur="validateDepartment()">
						<form:option value="" label="--Select Class--"  />
							<form:option value="5" label="5" />
							<form:option value="6" label="6" />
							<form:option value="7" label="7" />
							<form:option value="8" label="8" />
							<form:option value="9" label="9" />
							<form:option value="10" label="10" />
					</form:select>
				<td id="errdept"><form:errors path="department"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Section <font color="red">*</font></td>
				<td><form:input type="number" value="1" min="1" max="2"
						path="semester" class="specialTextbox" id="semester"
						onblur="validateSemester()" onfocus="semesterClear()" size="10" /></td>
				<td id="textSemester" style="color: red"><form:errors
						path="semester" /></td>
			</tr>
			<tr>
				<td>Phone Number <font color="red">*</font></td>
				<td><form:input path="phoneNo" class="specialTextbox"
						id="phoneNo" onblur="validatePhoneNo()" onfocus="phoneNoClear()"
						size="38" minlength="9" maxlength="10" /></td>
				<td id="textPhone" style="color: red"><form:errors
						path="phoneNo" /></td>
			</tr>
			<tr>
				<td>Email-id <font color="red">*</font></td>
				<td><form:input path="emailId" class="specialTextbox"
						id="email" onblur="emailValidation()" onfocus="emailClear()"
						size="38" /></td>
				<td id="errEmail" style="color: red"><form:errors
						path="emailId" /></td>
			</tr>
			<%
				String teacher_id = (String) request.getSession().getAttribute("teacher_id");
			%>
			<tr>
				<td></td>
				<td><input id="teacher_id" name="teacher_id" type="hidden"
					value="<%=teacher_id%>" /></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input class="specialButton"
					type="submit" value="Register"></input></td>
			</tr>

		</form:form>
	</table>
	<br /> <br /> <font style="font-size: 12px" class="error">Field
		marked * are mandatory.</font><br /> <br /> <br /> <br />

	<hr />
</center>

<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>