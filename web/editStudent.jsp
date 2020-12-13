<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="c" scope="request" class="ict.bean.StudentBean"/>
<%
    String type = c.getSid() != null ? "edit" : "add";
    String id = c.getSid() != null ? c.getSid() : "";
    String pwd = c.getPwd() != null ? c.getPwd() : "";
    String name = c.getName() != null ? c.getName() : "";
    String email = c.getEmail() != null ? c.getEmail() : "";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer</title>
    </head>
    <body>
        <h2><%=type%></h2>
        <form method="get" action="handleEditStudent">
            <input type="hidden" name="action"  value="<%=type%>" />
            <% if (type.equals("add")) {%>
            Sid: <input name="id"  type="text" value="<%=id%>"/> <br>
            <%} else {%>
            Sid: <input name="id"  type="text" value="<%=id%>" readonly/> <br>
            <% }%>
            Pwd: <input name="pwd"  type="text" value="<%=pwd%>"/> <br>
            Name: <input name="name"  type="text" value="<%=name%>"/> <br>
            Email: <input name="email"  type="text" value="<%=email%>"/> <br>
            <td ><input type="submit" value="submit"/> 
                <a href="handleStudent?action=list">Cancel</a>

        </form>
    </body>
</html>