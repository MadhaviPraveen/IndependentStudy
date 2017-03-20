<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link href= "styles.css" rel="stylesheet" type ="text/css">
<h1> Registration page</h1>
</head>
<body>
    <form method="POST" action="/IndStudy/RegistrationController">	
        <label for="cwid">CWID</label> <input type="text" name="cwid" id="cwid" autofocus required><br>	
	<label for="fname">First Name</label><input type="text" name="firstName" id="firstName"autofocus required><br>
	<label for="lname">Last Name</label><input type="text" name="lastName" id="lastName"autofocus required><br>
	<label for="uname">User Name</label><input type="text" name="userName" id="userName"autofocus required><br>
	<label for="password">Password</label><input type="password" name="passWord" id="passWord"autofocus required><br>
	<label for="stname">Street Name</label><input type="text" name="streetName" id="streetName"autofocus required><br>
	<label for="hnumber">House Number</label><input type="text" name="houseNumber" id="houseNumber"autofocus required><br>
	<label for="city">City</label><input type="text" name="city" id="city"><br>
	<label for="zcode">ZipCode</label><input type="text" name="zipCode" id="zipCode"autofocus required><br>
        <label for="male">Sex:  Male </label><input type="radio" name="sex" id="sex" value="M" checkedautofocus required>  
	Female: <input type="radio" name="sex" id="sex" value="F"autofocus required><br>
	<label for="dob">Date Of Birth</label> <input type="text" name="dob" value=""autofocus required><br>
	<input id="homePageSubmit" type="Submit" value="Register"></input>
    </form>
    <div class="errormsgRegistration">    
        <%=request.getAttribute("errorMsg") == null ? "" : request.getAttribute("errorMsg") %> 
    </div>
</body>
</html>