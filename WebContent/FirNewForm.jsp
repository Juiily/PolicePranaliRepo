<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Home Page</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700%7CPT+Serif:400,700,400italic' rel='stylesheet'>
 <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans" rel="stylesheet">
</head>

<style type="text/css">

.menu{
display: grid;
/* grid-template-columns: 40% 60%; */
width: 100%;
background-color: goldenrod;
}

.container-fluid{
    margin: 2px;

}

.Title{
padding-top: 20px;
text-align:left;
font-weight: bold;
color: black;
font-size: 35px;
font-family: 'Montserrat', sans-serif;
background-color: goldenrod;
line-height: 100px;
}

.menu{
font-family: 'Montserrat', sans-serif;
display: inline-block;
list-style: none;
font-size: 16px;
color:goldenrod;
font-weight: bold;
line-height: 80px;
text-transform: uppercase;

}

.c2{
   
width: 100%;
border-radius: 30px;
margin-top: 5px;
}
ul{
 
    list-style-type: none;
    margin-left: 40px;
}

li {
    display: inline;
}

li a{
    
    text-align: center;
    padding: 16px;
    text-decoration: none;
    list-style-type: none;
}

li a:hover{
    background-color: rgb(27, 160, 212);
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}


.footer{
    width: 100%;
    position:fixed;
    background-color:goldenrod;
    /* padding-left:20px;
    padding-top:5px; */
    font-size: 13px;
    font-weight: bold;
    font-family: 'Montserrat', sans-serif;

    bottom: 0;
    color:black;
}


</style>


</head>


<body style="background-color: lightgrey">

    

<div class= "container-fluid" style="margin: 0px; padding: 0px">

    
        <div class="Title row"> 
            <div class="col-4">Police Pranali </div>

            <div class="col-8 menu-bar">

                <div class="row">
                    <div class="menu" style="height: auto;" >
                        <div class="bar" style="padding-left: 40vw;">
                            <ul>
                            <li> <a href="homepage.html" style=" color: black;">Home</a></li>
                            <li><a href="About_Us.jsp" style=" color: black;"> About Us </a></li>
                            <li><a href="logout.jsp" style=" color: black;"> Logout </a> </li>
                            </ul>
                        </div>
                            
                        
                    </div> 
        
                </div>

            </div>
        </div>

    

</div>
   
    <!-- put here main logic form  -->
   
    <div class="c2" style="height: auto;"></div>
    
			 <h2>FIR DETAILS Form</h2>

 <!--     <form action="newFirForm" method="post" commandName="newObj">  
	<input type="submit" value="show fir list">
						</form>    -->
						
<form action="newFirForm" method="post">
<input type="submit" value="Show Fir List">
</form>					
						
<!--<a href="newFirForm"> show fir list</a> -->

<table>
  <tr>
    <th>FIR NO.</th>
    <th>CRIME TYPE</th>
    <th>CRIME LOCATION</th>
    <th>CRIME DATE</th>
    <!--   <th>Crime Date</th>  -->
  </tr>
  <c:forEach items="${newFir}" var="temp">
				<tr>
					
					<td>${temp.firId}</td>
					<td>${temp.crimeDesc}</td>
					<td>${temp.crimeLoc}</td>
					<td>${temp.crimeDate}</td>
					
					
					
					
				<td>
						<form action="firVictDetails" method="post" commandName="fId">
							<input type="hidden" value=${temp.firId} name="firId">							
							<input type="submit" value="Assign Officer">	</form>					
					</td>
					
					
				</tr>
			</c:forEach>
</table>

	 
<!-- 	
	<div class="back">
		<button herf="login"> Go Back</button>
	</div>
	 -->
	<!-- <script> 
	function goBack() {
		  window.history.back();
		}
	 </script> -->
	
    
	<div class="footer" style="height:30px">Copyright &copy; 2020 Police Pranali</div>


</body>
</html>