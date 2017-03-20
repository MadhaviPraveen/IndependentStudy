<%-- 
    Document   : CourseProfessor
    Created on : Nov 25, 2016, 3:49:08 PM
    Author     : ivatu
--%>

<%@page import="java.util.List"%>
<%@page import="IndependentStudy.Professor"%>
<%@page import="IndependentStudy.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>courseprofinsertion Page</title>
        <link href= "styles.css" rel="stylesheet" type ="text/css" >
    </head>
    <body>
        <h1>Course Professor Insertion Form</h1>
        <form method="POST" action="/IndStudy/CreateCourseProfessor">
            <%
                List<Course> _courses = (List<Course>)request.getAttribute("Course");
                List<Professor> profesrs = (List<Professor>)request.getAttribute("Professor");
            %>
            <nav>
                <ul>
                    <li><a href="/IndStudy/ProfInsertion.jsp"> Insert Professor </a></li>
                    <li><a href="/IndStudy/courseInsertion.jsp"> Insert Course </a></li>
                    <li><a href="/IndStudy/CourseProfessorController"> Course Professor Mapping </a><li>
                    <li><a href="/IndStudy/Logoutcontroller"> Logout </a></li>
                </ul>
            </nav>
            <div id="courseProfessor">
            <table>
                <tr> <td> Course</td></tr>
                <%
                    if (_courses != null) {
                        for (Course course : _courses) {
                            if (course == null) {
                                continue;
                            }
                %>
                <tr> <td>
                    <input type="radio" name="course" value="<%=course.getc_id()%>"> &nbsp; <%=course.getCourseName()%>
                </td></tr>
                  <% } }%>
            </table>
            <table>
                <tr> <td> Professor</td></tr>
                <%
                    if (profesrs != null) {
                        for (Professor prof : profesrs) {
                            if (prof == null) {
                                continue;
                            }
                %>
                <tr> <td>
                    <input type="radio" name="professor" value="<%=prof.getP_id()%>"> &nbsp; 
                        <%=prof.getFirstName()%> &nbsp; <%=prof.getLastNname()%>
                </td></tr>
                    <% } }%>
            </table>
                <input id="courseProfessorSubmit" type="submit" value="Submit"><br>
            </div>
        </form>
    </body>
</html>
