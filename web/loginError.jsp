<%-- 
    Document   : loginError
    Created on : 2020?12?6?, ??01:42:29
    Author     : raymo
--%>
<%
    String format = request.getParameter("format");
%>
<% if ("senior".equals(format)) {
%>    <%@ include file="/sen_login.jsp"%>
<%} else if ("student".equals(format)) {%>
<%@ include file="/stu_login.jsp"%>
<%} else if ("tech".equals(format)) {%>
<%@ include file="/tech_login.jsp"%>
<%}%>


<p style="color:red">Invalid ID or Password, please try again! </p>