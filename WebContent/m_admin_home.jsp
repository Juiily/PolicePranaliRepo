<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Home Page</title>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link
	href='http://fonts.googleapis.com/css?family=Montserrat:400,700%7CPT+Serif:400,700,400italic'
	rel='stylesheet'>
<link
	href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans"
	rel="stylesheet">
</head>

<style type="text/css">
.menu {
	display: grid;
	/* grid-template-columns: 40% 60%; */
	width: 100%;
	background-color: goldenrod;
}

.container-fluid {
	margin: 2px;
}

.Title {
	padding-top: 20px;
	text-align: left;
	font-weight: bold;
	color: black;
	font-size: 35px;
	font-family: 'Montserrat', sans-serif;
	background-color: goldenrod;
	line-height: 100px;
}

.menu {
	font-family: 'Montserrat', sans-serif;
	display: inline-block;
	list-style: none;
	font-size: 16px;
	color: goldenrod;
	font-weight: bold;
	line-height: 80px;
	text-transform: uppercase;
}

.c2 {
	width: 100%;
	border-radius: 30px;
	margin-top: 30px;
	margin-left: 500px;
	margin-right: 500px;
}

ul {
	list-style-type: none;
	margin-left: 40px;
}

li {
	display: inline;
}

li a {
	text-align: center;
	padding: 16px;
	text-decoration: none;
	list-style-type: none;
}

li a:hover {
	background-color: rgb(27, 160, 212);
}

.footer {
	width: 100%;
	position: fixed;
	background-color: goldenrod;
	/* padding-left:20px;
    padding-top:5px; */
	font-size: 13px;
	font-weight: bold;
	font-family: 'Montserrat', sans-serif;
	bottom: 0;
	color: black;
}
</style>


</head>


<body style="background-color: lightgrey">
<!-- 	<script>
		function showPsTable()
		{
			document.getElementById("table1").style.visibility="visible";
			return false;
		}

		function showEmpTable(){
			document.getElementById("table2").style.visibility="visible";
			return false;
		} -->
	</script>


	<div class="container-fluid" style="margin: 0px; padding: 0px">
		<div class="Title row">
			<div class="col-4">Police Pranali</div>

			<div class="col-8 menu-bar">
				<div class="row">
					<div class="menu" style="height: auto;">
						<div class="bar" style="padding-left: 40vw;">
							<ul>
								<li><a href="homepage.html" style="color: black;">Home</a></li>
								<li><a href="About_Us.jsp" style="color: black;"> AboutUs </a></li>
								<li><a href="logout.jsp" style="color: black;">Logout</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- put here main logic form  -->

	<div class="c2" style="height: auto;">

		<form action="pslist" method="post">
			<input type="submit" value="Show Police Stations">
		</form>
		
		<table id="table1" style="width: 500px;" border="1">
			<thead align="center">
				<tr>
					<th colspan="10">Police Station List</th>
				</tr>
				<tr>
					<th>PSName</th>
					<th>PSAdd</th>
					<th>Option</th>
				</tr>
			</thead>

			<c:forEach items="${psList}" var="temp">
				<tr>
					<td >${temp.ps_Name}</td>
					<td>${temp.ps_Address}</td>
					<td align="center">
						<form action="poList" method="post" commandName="poId">
							<input type="hidden" value=${temp.ps_Id } name="id"> <input
								type="submit" value="Select">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>

		<br> <br> <br> <br>


		<table id="table2" border="1" style="width: 500px">

			<thead align="center">
				<tr>
					<th colspan="15">Police Station List</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Mob</th>
					<th>Desig</th>
					<th>Email</th>
					<th>Dob</th>
					<th>Option</th>
					<th>Option</th>
				</tr>
			</thead>

			<c:forEach items="${poEmpList}" var="temp">
				<tr>
					
					<td>${temp.emp_name}</td>
					<td>${temp.emp_mob}</td>
					<td>${temp.emp_desig}</td>
					<td>${temp.emp_email}</td>
					<td>${temp.emp_dob}</td>
					<td>
						<form action="deleteAdmin" method="post" commandName="poId">
							<input type="hidden" value=${temp.emp_id } name="id"> <input
								type="hidden" value=${temp.role_id } name="roleId"> <input
								type="submit" value="Delete Admin">
						</form>
					</td>
					<td>
						<form action="assignAdmin" method="post" commandName="poId">
							<input type="hidden" value=${temp.emp_id } name="id"> <input
								type="hidden" value=${temp.role_id } name="roleId"> <input
								type="submit" value="Select Admin">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="footer" style="height: 30px">Copyright &copy; 2020
		Police Pranali</div>


</body>
</html>