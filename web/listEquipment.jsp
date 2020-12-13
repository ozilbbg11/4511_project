
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.EquipmentBean"%>
<%
    ArrayList<EquipmentBean> customers = (ArrayList<EquipmentBean>) request.getAttribute("equipment");
    out.println("<h1>Equipment list</h1>");
    out.println("<table border='1'               >");
    out.println("<tr>");
    out.println("<th>Equipment ID</th><th> Name</th> <th> Description</th><th> usage</th>");
    out.println("</tr>");
    // loop through the customer array to display each customer record
    for (int i = 0; i < customers.size(); i++) {
        EquipmentBean c = customers.get(i);
        out.println("<tr>");
        out.println("<td>" + c.getE_id() + "</td>");
        out.println("<td>" + c.getName() + "</td>");
        out.println("<td>" + c.getDescription() + "</td>");
        out.println("<td>" + c.getUsage() + "</td>");
        out.println("<td><a href=\"handleEquipment?action=delete&id=" + c.getE_id() + "\">delete</a></td>");
        out.println("<td><a href=\"handleEquipment?action=getEditCustomer&id=" + c.getE_id() + "\">edit</a></td>");
        out.println("</tr>");

    }
    out.println("</table>");
%>
