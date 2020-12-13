<%-- 
    Document   : welcome
    Created on : 2020年12月6日, 下午01:40:58
    Author     : raymo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <jsp:useBean id="StudentBean" class="ict.bean.StudentBean" scope="session"/>
        <jsp:useBean id="cart" class="ict.bean.CartBean" scope="session"/>
        <b> Hello,   <jsp:getProperty name="StudentBean" property="name"  />
         <% cart.initialize(StudentBean.getSid()); %>
        <br><a href="handleOrder?action=list" >Profile</a>
        <br><a href="handleReserve?action=list" >Make Reserve</a>
            
            <form method="post" action="studentLogin">
                <input type="hidden" name="action" value="logout">
                <input type="submit" value="Logout" name="logoutButton">
            </form>
    </body>
</html>
