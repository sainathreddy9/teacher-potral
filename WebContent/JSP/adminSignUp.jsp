<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="basicLayout1.jsp"></jsp:include>

<br />
<center>
	<h2>Sign Up</h2>

	<c:if test="${requestScope.error1 != null}">
		<h4 style="color: red;">${requestScope.error1}</h4>
	</c:if>
	<c:if test="${requestScope.error != null}">
		<h4 style="color: red;">${requestScope.error}</h4>
	</c:if>
	<table border="0" class="tableStyle">

		<form:form action="checkSignUp.htm" name="sForm"
			modelAttribute="adminDetails" onsubmit="validateSignUP()">

			<tr>
				<td>Teacher Id</td>
				<td><font color="red">*</font>&nbsp;<form:input
						path="teacherId" class="specialTextbox" id="teacherId"
						onblur="validateTeacherId()" onfocus="teacherIdClear()" /></td>
				<td id="errtid"><form:errors path="teacherId" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><font color="red">*</font>&nbsp;<form:input
						path="firstName" class="specialTextbox" id="firstName"
						onblur="validateFirstName()" onfocus="firstNameClear()" /></td>
				<td id="errfn"><form:errors path="firstName" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><font color="white">*</font>&nbsp;<form:input
						path="middleName" class="specialTextbox" id="middleName"
						onfocus="middleNameClear()" /></td>
				<td id="errmn"><form:errors path="middleName" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><font color="red">*</font>&nbsp;<form:input path="lastName"
						class="specialTextbox" id="lastName" onblur="validateLastName()"
						onfocus="lastNameClear()" /></td>
				<td id="errln"><form:errors path="lastName" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><font color="red">*</font>&nbsp;<form:input path="dob"
						class="specialTextbox" id="dob" onblur="validateDob()"
						onfocus="dobClear()" /></td>
				<td id="errdob"><form:errors path="dob" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><font color="red">*</font>&nbsp;<form:password
						path="password" class="specialTextbox" id="password"
						onblur="validatePassword()" onfocus="passwordClear()" /></td>
				<td id="errpwd"><form:errors path="password"
						cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Confirm Password</td>
				<td><font color="red">*</font>&nbsp;<form:password
						path="confirmPassword" class="specialTextbox" id="confirmPassword"
						onblur="validateCPassword()" onfocus="cPasswordClear()" /></td>
				<td id="errcpwd"><form:errors path="confirmPassword"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Class Feasibility</td>
				<td><font color="red">*</font>&nbsp;<form:select
						path="department" class="specialTextbox" id="department">
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
				<td><font color="white">*</font>&nbsp;<form:input path="phone"
						class="specialTextbox" id="phone" onblur="validatePhone()"
						onfocus="phoneClear()" minlength="9" maxlength="10" /></td>
				<td id="errphn"><form:errors path="phone" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Email Id</td>
				<td><font color="red">*</font>&nbsp;<form:input path="emailId"
						class="specialTextbox" id="emailId" /></td>
				<td id="erremil"><form:errors path="emailId"
						cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Qualification</td>
				<td><font color="red">*</font>&nbsp;<form:input
						path="qualification" class="specialTextbox" id="qualification" /></td>
				<td id="errqua"><form:errors path="qualification" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><font color="red">*</font>&nbsp;<form:input type="number"
						min="1" max="20" value="1" path="experience"
						class="specialTextbox" id="experience" /></td>
				<td id="errexp"><form:errors path="experience" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Admin Password</td>
				<td><font color="red">*</font>&nbsp;<form:password
						path="apassword" class="specialTextbox" id="apassword"
						onblur="validataePassword()" onfocus="apasswordClear()" /></td>
				<td id="errapwd"><form:errors path="apassword" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Sign Up" class="specialButton" />
		</form:form>
		<a href="home.htm" class="buttonLink"><button
				class="specialButton">Back</button></a>
		</td>
		</tr>

	</table>
	<br /> <br /> <font style="font-size: 12px" class="error">Note*:
		Sign up is Exclusive for SCTS staff.</font><br /> <br />
</center>





<jsp:include page="../HTML/BasicLayout2.html"></jsp:include>
