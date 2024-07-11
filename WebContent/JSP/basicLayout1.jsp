<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sri Chaitanya Techno School</title>

<link rel="stylesheet" href="HTML/HomePage.css" />
<link rel="stylesheet" href="HTML/TrackStatus.css" />
<script type="text/javascript" src="HTML/HomePage.js"></script>
<script type="text/javascript" src="HTML/StudentRegistration.js"></script>
<script type="text/javascript" src="HTML/AdminSignUP.js"></script>

</head>
<body class="verticalLine" onload="slideit()">


	<% String menu = (String)request.getAttribute("status");
	String role = (String)request.getSession().getAttribute("role");
			System.out.println(":: "+menu + "role" +role);
			if(role != null && role.equals("admin")){
				%>
	<jsp:include page="../HTML/AdminMenu.html"></jsp:include>
	<%
			}
			else { 
				%><jsp:include page="../HTML/StudentMenu.html"></jsp:include>
	<%
			} %>

	<div class="stay1"></div>

	<%String teacher_id = (String)request.getSession().getAttribute("teacher_id");
	String teacher_name = (String)request.getSession().getAttribute("teacher_name");
	if(teacher_id == null){
		teacher_id = "";
	}
	%>
	<div class="Head1">
		&emsp;&emsp;<br><img id="logo" alt="Logo" src="Images/scts_logo_1.png" height="50" />
		<h1 class="welcomeH1">Teacher
			Portal&emsp;&emsp;&nbsp;&nbsp;</h1>
		<%=teacher_id %>

	</div>


	<div class="mainContent">
		<hr />