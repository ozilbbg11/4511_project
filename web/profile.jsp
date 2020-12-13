
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.RecordBean"%>
<jsp:useBean id="StudentBean" class="ict.bean.StudentBean" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <h2>
            SID: <jsp:getProperty name="StudentBean" property="sid"  />     
            name: <jsp:getProperty name="StudentBean" property="name"  />   
            email: <jsp:getProperty name="StudentBean" property="email"  /> 
        </h2>

        <%
            ArrayList<RecordBean> customers = (ArrayList<RecordBean>) request.getAttribute("record");
            out.println("<h1>Record list</h1>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Record ID</th><th> Inventory ID </th> <th>Name</th> <th> Description</th><th> Due Date</th></th><th> Status</th>");
            out.println("</tr>");
            // loop through the customer array to display each customer record
            for (int i = 0; i < customers.size(); i++) {
                RecordBean c = customers.get(i);
                out.println("<tr>");
                out.println("<td>" + c.getRecord_id() + "</td>");
                out.println("<td>" + c.getI_id() + "</td>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getDescription() + "</td>");
                out.println("<td>" + c.getDue_date() + "</td>");
                out.println("<td>" + c.getStatus() + "</td>");
                out.println("<td><a href=\"handleOrder?action=delete&id=" + c.getRecord_id() + "&iid=" + c.getI_id() + "\">delete</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
        %>

    </body>
</html>
