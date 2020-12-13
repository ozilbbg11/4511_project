
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.InventoryBean"%>
<%
    ArrayList<InventoryBean> customers = (ArrayList<InventoryBean>) request.getAttribute("inventory");
    out.println("<h1>Inventory list</h1>");
    out.println("<table border='1'               >");
    out.println("<tr>");
    out.println("<th>Inventory ID</th><th>Equipment ID</th> <th>name</th> <th> Description</th><th> Availability</th>");
    out.println("</tr>");
    // loop through the customer array to display each customer record
    for (int i = 0; i < customers.size(); i++) {
        InventoryBean c = customers.get(i);
        out.println("<tr>");
        out.println("<td>" + c.getI_id() + "</td>");
        out.println("<td>" + c.getE_id() + "</td>");
        out.println("<td>" + c.getName() + "</td>");
        out.println("<td>" + c.getDescription() + "</td>");
        out.println("<td>" + c.getAvailability() + "</td>");
        out.println("<td><a href=\"handleInventory?action=delete&id=" + c.getI_id() + "\">delete</a></td>");
        out.println("<td><a href=\"handleInventory?action=getEditCustomer&id=" + c.getI_id() + "\">edit</a></td>");
        out.println("</tr>");

    }
    out.println("</table>");
%>
