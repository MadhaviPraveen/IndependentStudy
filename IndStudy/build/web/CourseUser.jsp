<%-- 
    Document   : CourseUSer
    Created on : Nov 26, 2016, 12:28:09 PM
    Author     : ivatu
--%>

<%@page import="IndependentStudy.Course"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href= "styles.css" rel="stylesheet" type ="text/css" >
    </head>
    <body>
        
        <h1>Selecting a Course</h1>
            <form method="POST" action="/IndStudy/CreateCourseUser">
            <%
                List<Course> courses = (List<Course>)request.getAttribute("Course");
            %>
             <nav>
                    <ul>
                        <li><a href="/IndStudy/CourseUserController">Select Courses</a> </li>
                        <li><a href="/IndStudy/Logoutcontroller"> Logout </a></li>

                    </ul>
                </nav>
            <div id="courseuser">
            <table>
                <tr> <td> Course</td></tr>
            <%
                if (courses != null) {
                    for (Course course : courses) {
                        if (course == null) {
                            continue;
                        }
            %>
                <tr> <td>
                    <input type="radio" name="course" value="<%=course.getc_id()%>"> &nbsp; <%=course.getCourseName()%>
                </td></tr>
           <% } }%>
            </table>
            <input type="submit" value="Submit"><br>
            </div>
        </form>

    </body>
</html>
