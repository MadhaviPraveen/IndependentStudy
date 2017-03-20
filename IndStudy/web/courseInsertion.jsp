<%-- 
    Document   : courseSelection
    Created on : Nov 23, 2016, 7:05:40 PM
    Author     : ivatu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Insertion Page</title>
        <link href= "styles.css" rel="stylesheet" type ="text/css" >
    </head>
    <body>
        <h1>Course Insertion Details</h1></br></br>
        <nav>
            <ul>
                <li><a href="/IndStudy/ProfInsertion.jsp"> Insert Professor </a></li>
                <li><a href="/IndStudy/courseInsertion.jsp"> Insert Course </a></li>
                <li><a href="/IndStudy/CourseProfessorController"> Course Professor Mapping </a><li>
                <li><a href="/IndStudy/Logoutcontroller"> Logout </a></li>
            </ul>
        </nav>
	<form method="POST" action="/IndStudy/CourseInsertionController">	
            <label for="semester">Semester</label><input type="text" name="semester" id="semester"></br>
            <label for="courseName">Course Name</label><input type="text" name="course" id="course"></br>
            <label for="credits">Credits</label><input type="number" name="credits" id="credits"></br>
            <input id="courseInsertSubmit" type="Submit" value="Submit"></input>
        </form>  
    </body>
</html>
