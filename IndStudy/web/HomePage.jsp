<%-- 
    Document   : LoginSuccess
    Created on : Nov 12, 2016, 10:31:17 AM
    Author     : ivatu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="IndependentStudy.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success </title>
        <link href= "styles.css" rel="stylesheet" type ="text/css" >
    </head>
    <body>
        <h1 id="mainHeading">Student Information System</h1>
        
        
        <% User user = (User) session.getAttribute("User"); %>
        <div class="username"><h3> Welcome <%= user.getF_name() %>  </h3></div>
            
        <% 
            if("A".equalsIgnoreCase(user.getUserType())){ %>
                <nav>
                    <ul>
                        <li><a href="/IndStudy/ProfInsertion.jsp"> Insert Professor </a></li>
                        <li><a href="/IndStudy/courseInsertion.jsp"> Insert Course </a></li>
                        <li><a href="/IndStudy/CourseProfessorController"> Course Professor Mapping </a><li>
                        <li><a href="/IndStudy/Logoutcontroller"> Logout </a></li>
                    </ul>
                </nav>
            <% } else { %>
                <nav>
                    <ul>
                        <li><a href="/IndStudy/CourseUserController">Select Courses</a> </li>
                        <li><a href="/IndStudy/Logoutcontroller"> Logout </a></li>
                    </ul>
                </nav>
       <%}%> 
        
        
    </body>
</html>

