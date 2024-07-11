<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="basicLayout1.jsp"></jsp:include>
<script>
	function enableUpdate() {
		document.getElementById("updateProfile").disabled = false;
		document.getElementById("department").disabled = false;
		document.getElementById("phone").disabled = false;
		document.getElementById("emailId").disabled = false;
		document.getElementById("qualification").disabled = false;
		document.getElementById("experience").disabled = false;

	}
</script>
<br />
<center>
	<h2>My Profile</h2>

	<c:if test="${requestScope.results != null}">
		<h4 style="color: red;">${requestScope.results}</h4>
	</c:if>
	<c:if test="${requestScope.error != null}">
		<h4 style="color: red;">${requestScope.error}</h4>
	</c:if>
	<table border="0" class="tableStyle">

		<form:form action="updateProfile.htm" name="sForm"
			modelAttribute="adminDetails" onsubmit="validateSignUP()">

			<tr>
				<td>Teacher Id</td>
				<td><form:input path="teacherId" class="specialTextbox"
						id="teacherId" onblur="validateTeacherId()"
						onfocus="teacherIdClear()" disabled="true" /></td>
				<td id="errtid"><form:errors path="teacherId"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" class="specialTextbox"
						id="firstName" onblur="validateFirstName()"
						onfocus="firstNameClear()" disabled="true" /></td>
				<td id="errfn"><form:errors path="firstName"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><form:input path="middleName" class="specialTextbox"
						id="middleName" onfocus="middleNameClear()" disabled="true" /></td>
				<td id="errmn"><form:errors path="middleName"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" class="specialTextbox"
						id="lastName" onblur="validateLastName()"
						onfocus="lastNameClear()" disabled="true" /></td>
				<td id="errln"><form:errors path="lastName"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><form:input path="dob" class="specialTextbox" id="dob"
						onblur="validateDob()" onfocus="dobClear()" disabled="true" /></td>
				<td id="errdob"><form:errors path="dob" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Class Feasibility</td>
				<td><form:select path="department" class="specialTextbox"
						id="department" disabled="true">
						<form:option value="" label="--Select Class--" />
							<form:option value="5" label="5" />
							<form:option value="6" label="6" />
							<form:option value="7" label="7" />
							<form:option value="8" label="8" />
							<form:option value="9" label="9" />
							<form:option value="10" label="10" />
					</form:select>
				<td id="errdpt"><form:errors path="department"
						cssStyle="color:red" /></td>

			</tr>
			<tr>
				<td>Phone</td>
				<td><form:input path="phone" class="specialTextbox" id="phone"
						onblur="validatePhone()" onfocus="phoneClear()" disabled="true" /></td>
				<td id="errphn"><form:errors path="phone" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Email Id</td>
				<td><form:input path="emailId" class="specialTextbox"
						id="emailId" disabled="true" /></td>
				<td id="erremil"><form:errors path="emailId"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Qualification</td>
				<td><form:input path="qualification" class="specialTextbox"
						id="qualification" disabled="true" /></td>
				<td id="errqua"><form:errors path="qualification"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><form:input type="number" path="experience"
						class="specialTextbox" id="experience" disabled="true" /></td>
				<td id="errexp"><form:errors path="experience"
						cssStyle="color:red" /></td>
			</tr>

			<tr>

				<td align="center"><input type="submit" id="updateProfile"
					value="Update Profile" class="specialButton" disabled="true" /></td>
		</form:form>
		<td align="center"><button class="specialButton"
				onclick="enableUpdate()">Edit</button></td>
		<td><a href="home.htm" class="buttonLink"><button
					class="specialButton">Back</button></a></td>
		</tr>

	</table>
	<br /> <br /> <br />
</center>





<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>
