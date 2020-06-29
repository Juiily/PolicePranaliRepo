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
	margin-top: 5px;
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



	<div class="container-fluid" style="margin: 0px; padding: 0px">


		<div class="Title row">
			<div class="col-4">Police Pranali</div>

			<div class="col-8 menu-bar">

				<div class="row">
					<div class="menu" style="height: auto;">
						<div class="bar" style="padding-left: 40vw;">
							<ul>
								<li><a href="homepage.html" style="color: black;">Home</a></li>
								<li><a href="About_Us.jsp" style="color: black;"> About
										Us </a></li>
								<li><a href="logout.jsp" style="color: black;"> Logout
								</a></li>
							</ul>
						</div>


					</div>

				</div>

			</div>
		</div>



	</div>

	<!-- put here main logic form  -->

	<div class="c2" style="height: auto;"></div>
	<h2>Accused Form</h2>
	<div class="container">

		<div></div>
		<div>
			<form class="Login-form"  action="Acc-form" method="post"
				commandName="accForm">
				<table align="center">

					<tbody>
						<tr>
							<td><b />ACCUSED NAME</td></br>
							<td><input type="text" name="accName" required
								placeholder="Enter victim name"></td></br>
						</tr>
						<tr>
							<td><b />GENDER</td>
							<td><select name="accSex" required>
									<option value="-1">select status</option>
									<option value="male">Male</option>
									<option value="female">Female</option>
									<tr>
										<td><b />DATE OF BIRTH</td>
										<td><input type="date" name="accDob" required
											placeholder="Enter date in format yyyy/mm/dd"></td>
									</tr>
									<tr>
										<td><b />ACCUSED ADDRESS</td>
										<td><input type="text" name="accAdd" required
											placeholder="Enter victim address"></td>
									</tr>
									<tr>
										<td><b />CRIME TYPE</td>
										<td><select name="crimeType" required>
												<option value="-1">select status</option>
												<option value="rape">Rape</option>
												<option value="murder">Murder</option>
										</select></td>
									</tr>
									<tr>
										<td><b />CRIME DATE</td>
										<td><input type="date" name="crimeDate" required
											placeholder="Enter date in format yyyy/mm/dd"></td>
									</tr>
									<tr>
										<td><b />STATUS</td>
										<td><input type="number" name="status" required
											placeholder="status"></td>
									</tr>
									<tr>
										<td><b />Description :</td>
										<td><textarea rows="4" cols="50">
								</textarea></td>

										<td><input type="submit" value="Add"></td>
									</tr>
							
					</tbody>
				</table>
			</form>
		</div>
	</div>


	<div class="footer" style="height: 30px">Copyright &copy; 2020
		Police Pranali</div>


</body>
</html>