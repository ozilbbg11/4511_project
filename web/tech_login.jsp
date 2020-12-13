<%-- 
    Document   : tech_login
    Created on : 2020年12月6日, 上午11:44:17
    Author     : raymo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Technician</h1>
        <form method="post" action="technicianLogin">
            <jsp:include page="login.jsp" />
        </form>
    </body>
</html>
