<%-- 
    Document   : login
    Created on : Nov 12, 2016, 7:41:06 AM
    Author     : ivatu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login JSP Page</title>
        <link href= "bootstrap.css" type ="text/css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <center><h1>Login</h1></center>
        <form method="POST" action="/IndStudy/LoginCredentials">
            <table align = "center">
                <tr>
                    <th align = "right">Username: </th>
                    <td><input type="text" name="userName" id="userName"></td>
                </tr>
                <tr>
                    <th align = "right"> Password: </th>
                    <td><input type="password" name="password" id="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                    <input type="submit" value="Log In" class = "btn btn-primary"></td>
                </tr>
            </table>
            Register <a href="/IndStudy/login.jsp"> Please Register </a><br>
        </form>
        <div class="errormsg">    
            <%=request.getAttribute("errorMsg")== null ? "" : request.getAttribute("errorMsg") %> 
        </div>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
