
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.InventoryBean"%>
<jsp:useBean id="StudentBean" class="ict.bean.StudentBean" scope="session"/>
<jsp:useBean id="cart" class="ict.bean.CartBean" scope="session"/>

<%
    ArrayList<String> contents = cart.getContents();
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
        if("available".equals(c.getAvailability())){
                if(contents.contains(c.getI_id())){
                    out.println("<td>Added</td>");
            }
                else{
                    out.println("<td><a href=\"handleReserve?action=getEditCustomer&id=" + c.getI_id() + "\">add to cart</a></td>");
                }
        }
        out.println("</tr>");

    }
    out.println("</table>");
%>
