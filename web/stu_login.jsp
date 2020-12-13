<%-- 
    Document   : stu_login
    Created on : 2020年12月6日, 上午11:44:07
    Author     : raymo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Login</title>
    </head>
    <body>
        <h1>Student Login</h1>
        <form method="post" action="studentLogin">
            <jsp:include page="login.jsp" />
            
        </form>
            
    </body>
</html>
