<%-- 
    Document   : admin
    Created on : 2020年12月11日, 下午09:52:58
    Author     : raymo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <jsp:useBean id="TechnicianBean" class="ict.bean.TechnicianBean" scope="session"/>
        <b> Hello,   <jsp:getProperty name="TechnicianBean" property="name"  />
            <br><a href="accountManage.jsp" >Account Management</a>
            <form method="post" action="seniorLogin">
                <input type="hidden" name="action" value="logout">
                <input type="submit" value="Logout" name="logoutButton">
            </form>
    </body>
</html>
