<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Homepage</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700%7CPT+Serif:400,700,400italic' rel='stylesheet'>
<link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans" rel="stylesheet">
</head>

<style type="text/css">
body{
 
  	background-repeat:no-repeat;
  	background-attachment:fixed;
    background-color:aliceblue;
    height: 100vh;
    background-size: cover;
    background-position: center;
}

.menu{
  	display: grid;
    grid-template-columns: 40% 60%;
	width: 100%;
	background-color:goldenrod;
}

.name{
	padding-top: 20px;
	text-align:left;
	padding-left: 40px;
	font-weight: bold;
	color: black;
	font-size: 35px;
	font-family: 'Montserrat', sans-serif;
}

.rightmenu{
	padding-left: 30%;
}


.rightmenu ul li {
	font-family: 'Montserrat', sans-serif;
	display: inline-block;
	list-style: none;
	font-size: 16px;
	color:white;
	font-weight: bold;
	line-height: 100px;
	margin-left: 40px;
	text-transform: uppercase;
}

.rightmenu ul li:hover{
	color: brown;
}

.welcome{
	padding-left:650px;
	padding-top:15px;
	color: black;
	font-size: 30px;
	font-family: 'Montserrat', sans-serif;
}

.c2{
    display: grid; 
	width: 100%;
	border-radius: 30px;
	margin-top: 5px;
}



.pemp{

    display: grid;
    justify-content: center;
    align-content: center;
    height: 80%;
}

button{
	background-color:khaki;
	color: brown;
	border-radius:20px;
	width: 250px;
	font-size:20px;
	font-weight: bold;
}

.fixed-footer{
    width: 100%;
    position:fixed;
    background-color:goldenrod;
    padding-left:5px;
    padding-top:5px;
    font-size: 13px;
    font-weight: bold;
    font-family: 'Montserrat', sans-serif;

    bottom: 0;
    color:black;
}
</style>

<body style="background-color:lightgray">
	<div class= "container-fluid" style="margin: 0px;padding: 0px">
	<div class="menu"style="height: 90px">
<div class="name">Police Pranali</div>
	
<div class="rightmenu">
<ul>
<li id="fisrtlist"><a href="home.jsp">HOME</a></li>
	<li><a href="about.jsp">About Us</a></li>
	<li><a href="contact.jsp">Contact</a></li>
	<li><a href="logout.jsp"> Logout</a> </li>
</ul>
</div>

</div>
    <div class="bckimg" style="height: 200px">
    <div class="welcome"><b>FIR FORM</b></div>

<div class="c2" style="height: 200px">
		<div class="container">
				
			  <div></div>
			  <div>  
     <form action="fir_add.jsp" method="post" >
		<table align="center" >
			
			<tbody>
				<tr><td><b/>VICTIM NAME</td>
				<td><input type="text" name="vName" required placeholder="Enter victim name" ></td></tr>
				<tr><td><b/>VICTIM GENDER</td>
				<td><select name="vGender">
				<option value="MALE">MALE</option>
				<option value="FEMALE">FEMALE</option>
				</select></td></tr>
				<tr><td><b/>VICTIM ADDRESS</td>
				<td><input type="text" name="vAdd" required placeholder="Enter victim address" ></td></tr>
				<tr><td><b/>MOBILE NUMBER</td>
				<td><input type="text" name="vMob" pattern="[6000000000-9999999999]{10}" required placeholder="Enter victim mobile no." ></td></tr>
				<tr><td><b/>VICTIM EMAIL ID</td>
				<td><input type="email" name="vEmail" required placeholder="Enter victim Email id" ></td></tr>
				<tr><td><b>CRIME TYPE</b></td>
				<td><select name="crimeType">
				<option value="300">murder</option>
				<option value="400">rape</option>
				
				</select>  </td>
				
				</tr>
				<tr><td><b/>INCIDENT DATE</td>
				<td><input type="date" name="crimeDate" required placeholder="Enter date in format yyyy/mm/dd" ></td></tr>
				
				<tr><td><b/>CRIME LOCATION</td>
				<td><input type="text" name="crimeLoc" required placeholder="Enter crime location" ></td></tr>
				
				<tr><td><input type="submit" value="Add" ></td></tr>
			</tbody>
		</table>
	</form>
</div>
</div>
<div ></div>
    
<div class="fixed-footer" style="height:30px">Copyright &copy; 2020 Police Pranali</div>
</div>
</div>
</body>
</html>