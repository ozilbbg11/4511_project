
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.TechnicianBean"%>
<%
    ArrayList<TechnicianBean> customers = (ArrayList<TechnicianBean>) request.getAttribute("tech");
    out.println("<h1>Technician list</h1>");
    out.println("<table border='1'               >");
    out.println("<tr>");
    out.println("<th>UID</th><th> Password</th> <th> name</th><th> email</th><th> Rank</th>");
    out.println("</tr>");
    // loop through the customer array to display each customer record
    for (int i = 0; i < customers.size(); i++) {
        TechnicianBean c = customers.get(i);
        out.println("<tr>");
        out.println("<td>" + c.getUid() + "</td>");
        out.println("<td>" + c.getPwd() + "</td>");
        out.println("<td>" + c.getName() + "</td>");
        out.println("<td>" + c.getEmail() + "</td>");
        out.println("<td>" + c.getRank() + "</td>");
        out.println("<td><a href=\"handleTech?action=delete&id=" + c.getUid() + "\">delete</a></td>");
        out.println("<td><a href=\"handleTech?action=getEditCustomer&id=" + c.getUid() + "\">edit</a></td>");
        out.println("</tr>");

    }
    out.println("</table>");
%>
