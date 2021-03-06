<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Master Admin Home</title>
	<c:if test="${sessionScope.userName == null }" >
			<c:redirect url="login.jsp" ></c:redirect>
	</c:if>
<link rel="icon" href="data:image/jpeg;base64,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" >

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
	width: auto;
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
		<h3>
			Welcome Master-Admin <%=session.getAttribute("userName")%>
		</h3>
	<!-- put here main logic form  -->

	<div class="c2" style="height: auto;">

		<form action="pslist" method="post">
			<input type="submit" value="Show Police Stations">
		</form>
		
		<table id="table1" style="width: 800px;height: 200px" border="1">
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
					<td>${temp.ps_Name}</td>
					<td>${temp.ps_Address}</td>
					<td align="center">
						<form action="poList" method="post" commandName="poId">
							<input type="hidden" value=${temp.ps_Id } name="id"> 
							<input type="submit" value="Select">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>

		<br> <br> <br> <br>


		<table id="table2" border="1" style="width: 800px;height: 250px">
			<thead align="center">
				<tr>
					<th colspan="15">Police Station List</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Designation</th>
					<th>Contact</th>					
					<th>Email</th>
					<th>Date Of Birth</th>
					<th>Role Assigned</th>
					<th align="center">Option</th>
					
				</tr>
			</thead>

		<c:forEach items="${descList}" var="temp" >
				<tr>
					
					<td>${temp.emp_name}</td>
					<td>${temp.emp_desig}</td>
					<td>${temp.emp_mob}</td>
					<td>${temp.emp_email}</td>
					<td>${temp.emp_dob}</td>
					<td>${temp.role_desc}</td>
					<td>
						<form action="assignAdmin" method="post" commandName="poId">
							<input type="hidden" value=${temp.emp_id } name="empId"> 
							<input type="hidden" value=${temp.role_id } name="roleId">
							<input type="hidden" value=${temp.ps_id } name="psId">
							<input type="submit" value="Update">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="footer" style="height: 30px">Copyright &copy; 2020
		Police Pranali</div>


<script type = "text/javascript">
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>

</body>
</html>