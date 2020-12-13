<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="c" scope="request" class="ict.bean.TechnicianBean"/>
<%
    String type = c.getUid() != null ? "edit" : "add";
    String id = c.getUid() != null ? c.getUid() : "";
    String pwd = c.getPwd() != null ? c.getPwd() : "";
    String name = c.getName() != null ? c.getName() : "";
    String email = c.getEmail() != null ? c.getEmail() : "";
    String rank = c.getRank() != null ? c.getRank() : "";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer</title>
    </head>
    <body>
        <h2><%=type%></h2>
        <form method="get" action="handleEditTech">
            <input type="hidden" name="action"  value="<%=type%>" />
            <% if (type.equals("add")) {%>
            Uid: <input name="id"  type="text" value="<%=id%>"/> <br>
            <%} else {%>
            Uid: <input name="id"  type="text" value="<%=id%>" readonly/> <br>
            <% }%>
            Pwd: <input name="pwd"  type="text" value="<%=pwd%>"/> <br>
            Name: <input name="name"  type="text" value="<%=name%>"/> <br>
            Email: <input name="email"  type="text" value="<%=email%>"/> <br>
            <% if (rank.equals("senior")) {%>
            Rank: <input name="rank"  type="radio" value="senior" checked/>Senior <input name="rank"  type="radio" value="technician"/>Technician <br>
            <%} else if (rank.equals("technician")) {%>
            Rank: <input name="rank"  type="radio" value="senior"/>Senior <input name="rank"  type="radio" value="technician" checked/>Technician <br>
            <% } else {%>
            Rank: <input name="rank"  type="radio" value="senior"/>Senior <input name="rank"  type="radio" value="technician" />Technician <br>
            <% }%>
            <td ><input type="submit" value="submit"/> 
                <a href="handleTech?action=list">Cancel</a>

        </form>
    </body>
</html>
