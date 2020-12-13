<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="c" scope="request" class="ict.bean.EquipmentBean"/>
<%
    String type = c.getE_id() != null ? "edit" : "add";
    String id = c.getE_id() != null ? c.getE_id() : "";
    String name = c.getName() != null ? c.getName() : "";
    String description = c.getDescription() != null ? c.getDescription() : "";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer</title>
    </head>
    <body>
        <h2><%=type%></h2>
        <form method="get" action="handleEditEquipment">
            <input type="hidden" name="action"  value="<%=type%>" />
            <% if (type.equals("add")) {%>
            Equipment ID: <input name="id"  type="text" value="<%=id%>"/> <br>
            <%} else {%>
            Equipment ID <input name="id"  type="text" value="<%=id%>" readonly/> <br>
            <% }%>
            Name: <input name="name"  type="text" value="<%=name%>"/> <br>
            Description <textarea name="description"><%=description %></textarea> <br>
            <td ><input type="submit" value="submit"/> 
                <a href="handleEquipment?action=list">Cancel</a>

        </form>
    </body>
</html>
