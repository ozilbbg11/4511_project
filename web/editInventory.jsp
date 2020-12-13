<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.bean.EquipmentBean"%>
<%
    ArrayList<EquipmentBean> customers = (ArrayList<EquipmentBean>) request.getAttribute("c");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Inventory</title>
    </head>
    <body>
        <h2>Add Inventory</h2>
        <form method="get" action="handleAddInventory">
            <input type="hidden" name="action"  value="add" />

            Inventory ID: <input name="id"  type="text" value=""/> <br>
            Equipment ID: <select name="eid">
            <%  for (int i = 0; i < customers.size(); i++) {
                EquipmentBean c = customers.get(i);
                 out.println("<option value='"+c.getE_id()+"'>" + c.getE_id() + "   "+c.getName()+"</option>");
            }%>
            </select>
            <td ><input type="submit" value="submit"/> 
                <a href="handleInventory?action=list">Cancel</a>

        </form>
    </body>
</html>
