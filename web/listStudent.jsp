
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.StudentBean"%>
<%
    ArrayList<StudentBean> customers = (ArrayList<StudentBean>) request.getAttribute("student");
    out.println("<h1>Student list</h1>");
    out.println("<table border='1'               >");
    out.println("<tr>");
    out.println("<th>SID</th><th> Password</th> <th> name</th><th> email</th>");
    out.println("</tr>");
    // loop through the customer array to display each customer record
    for (int i = 0; i < customers.size(); i++) {
        StudentBean c = customers.get(i);
        out.println("<tr>");
        out.println("<td>" + c.getSid() + "</td>");
        out.println("<td>" + c.getPwd() + "</td>");
        out.println("<td>" + c.getName() + "</td>");
        out.println("<td>" + c.getEmail() + "</td>");
        out.println("<td><a href=\"handleStudent?action=delete&id=" + c.getSid() + "\">delete</a></td>");
        out.println("<td><a href=\"handleStudent?action=getEditCustomer&id=" + c.getSid() + "\">edit</a></td>");
        out.println("</tr>");

    }
    out.println("</table>");
%>
