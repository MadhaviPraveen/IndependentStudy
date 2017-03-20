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
        <link href= "styles.css" rel="stylesheet" type ="text/css" >
    </head>
    <body>
        <div class="align-center-with-fixed-width">
        <fieldSet>
        <h1>Login</h1>
        <form method="POST" action="/IndStudy/LoginCredentials">
            
            <label for="username">Username</label>
                <input type="text" name="userName" id="userName"><br/>
            <label for="password">Password</label>              
                <input type="password" name="password" id="password"><br/>
            <div class="errormsg">    
                <%=request.getAttribute("errorMsg") == null ? "" : request.getAttribute("errorMsg") %> 
            </div>
            
            <div class="register">    
                <a href="/IndStudy/registration.jsp"> Register </a> </div>
            <input id="submit" type="submit" value="Log In">   
                
        </form>
        </fieldset> 
        </div>
    </body>
</html>
