<%-- 
    Document   : ProfInsertion
    Created on : Nov 23, 2016, 8:43:11 PM
    Author     : ivatu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prof Insertion Page</title>
        <link href= "styles.css" rel="stylesheet" type ="text/css" >
    </head>
    <body>
        <h1>Professor Insertion Details</h1></br></br>
        <nav>
            <ul>
               <li><a href="/IndStudy/ProfInsertion.jsp"> Insert Professor </a></li>
                <li><a href="/IndStudy/courseInsertion.jsp"> Insert Course </a></li>
                <li><a href="/IndStudy/CourseProfessorController"> Course Professor Mapping </a><li>
                <li><a href="/IndStudy/Logoutcontroller"> Logout </a></li>
            </ul>
        </nav>
        <form method="POST" action="/IndStudy/ProfInsertionController">	
            <label for="firstName">First Name</label><input type="text" name="firstName" id="firstName"></br>
            <label for="lastName">Last Name</label><input type="text" name="lastName" id="lastName"></br>
            <label for="dob">Date Of Birth</label><input type="text" name="dob" value=""></br>
            <label for="exp">Experience</label><input type="text" name="exp" id="exp"></br>
            <label for="study">Study place</label><input type="text" name="studyPlace" id="studyPlace"></br>
            <input id="ProfInsertsubmit" type="Submit" value="Register"></input>
        </form>
    </body>
</html>
