<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="cart" scope="session" class="ict.bean.CartBean"/>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.InventoryBean"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cart</title>
</head>
<body>
    <h2>Cart</h2>

<form method="get" action="handleAddRecord">
    <input type="hidden" name="action"  value="add" />
    <%
        ArrayList<InventoryBean> customers = (ArrayList<InventoryBean>) request.getAttribute("c");
        ArrayList<String> contents = cart.getContents();
        for (int i = 0; i < contents.size(); i++) {
            out.println("<p>Inventory ID: " + contents.get(i));
            for (int k = 0; k < customers.size(); k++) {
                InventoryBean c = customers.get(k);
                if (contents.get(i).equals(c.getI_id())) {
                    out.println("Equipment ID: " + c.getE_id() + "Name: " + c.getName() + "Description" + c.getDescription());
                    out.println("<a href=\"handleReserve?action=delete&id=" + c.getI_id() + "\">delete</a> </p>");
                }
            }
        }

    %>

    <input type="submit" value="submit"/> 
    <a href="handleReserve?action=list">Back</a>
</form>
</body>
</html>