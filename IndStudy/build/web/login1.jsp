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
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <section class="container">
            <div class="login"> <h1>Login Crdentials</h1>
                <form method="POST" action="/IndStudy/LoginCredentials">
                    <p><input type="text" name="userName" id="userName" value="" placeholder="Username"></p>
                    <p><input type="password" name="password" id="password" value="" placeholder="Password"></p>
                    <p class="submit"> <input type="submit" name="commit" value="Login"></p>
                </form>
                <%=request.getAttribute("errorMsg")== null ? "" : request.getAttribute("errorMsg") %> 
            </div>
            <div class="login-help">
                <p>Don't have an account? <a href="/IndStudy/registration.jsp">Register</a>.</p>
            </div>
        </section>
    </body>
</html>
