

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Management</title>
    </head>
    <body>
        <jsp:useBean id="TechnicianBean" class="ict.bean.TechnicianBean" scope="session"/>
        <b> Hello,   <jsp:getProperty name="TechnicianBean" property="name"  />
        <ul><li>  <a href="editEquipment.jsp" >Add Equipment </a></li>
            <li>  <a href="handleEquipment?action=list" >Show Equipment List </a></li>
            <li>  <a href="handleInventory?action=getEditCustomer" >Add Inventory </a></li>
            <li>  <a href="handleInventory?action=list" >Show Inventory List </a></li>
            
        </ul>
    </body>
</html>
