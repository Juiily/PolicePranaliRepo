<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    
    
    
    <title>Login page</title>
    
    <style>
    body{
   	background-image:url('');
  	background-repeat:no-repeat;
 	background-attachment:fixed;
    background-color:gray;
    height: 100vh;
    background-size: cover;
    background-position: center;
}

.head-Title{

font-size: 20px;
width:200px ;
padding: 40px;  
background-image:url('');   

    
}

.login-page{
    
  width: 360px;
  padding:10% 0 0 ;
  margin: auto;  
}

.form{

    position: relative;
    z-index: 1;
    /* background:; */
    max-width: 360px;
    margin: 0 auto 100px;
    padding: 45px;
    text-align: center;
    box-shadow: 10px 10px 5px black;
}

.form input{

    font-family: "Roboto",sans-serif;
    outline: 1;
    background: #f2f2f2;
    width: 100%;
    border: 0;
    margin: 0 0 15px;
    padding: 15px;
    box-sizing: border-box;
    font-size: 14px;
}

.form button{
    font-family: "Roboto",sans-serif;
    text-transform: uppercase;
    outline: 0;
    background: maroon;
    width: 100%;
    border: 0;
    padding: 15px;
    color: #FFFFFE;
    font-size: 14px;
    cursor: pointer;
}

.form button:hover,.form button:active{
    background: #43A047;

}

.form .message{
   margin: 15px 0 0;
   color: aliceblue;
   font-size: 12px;

}

.form .message a{
    color:#4CAF50;
    text-decoration:none ;
}

    
    </style>

</head>
<body>

<div class="container-fluid">
	<div class="container">
		<div class="row-1 ">
			<div class="head-Title">
				<div class="col-3" ></div>
				<div class="col-xs-1 center-block" style="font-size :50px; color:white; font-family:Arial Black, Gadget, sans-serif; align-items: center;" > Police Pranali </div>
				<div class="col-3" ></div>
			</div>
			
			
			<div class="login-page">
		    	<div class="form"> 
                    <p >
		    	    <form action="login" method="post" class="register-form">
		                <div class="col-3"></div>
                        <div class="col-6" style="font-size:20px; font-family: Lucida Sans Unicode, Gadget, sans-serif; color:white">Admin login</div> 
                        <div class="col-3"><br></div> 
                        <input type="text" placeholder="User Email" name="userEmail"/><br>
                        <input type="password" placeholder="Password" name="userPassword"/><br>
                
                        <input class="btn btn-success" type="submit" value="Login" style="height:50px;color:white; background-color:blue; padding:3px"/>
                    
                    </form>
                    </p>
		    	</div>
		    </div>
    
    
   	 </div>
    </div>
    
</div>

</body>
</html>