<%-- 
    Document   : logout
    Created on : 09/04/2021, 5:58:18 AM
    Author     : ormus
--%>
<%@page import = "model.Customer" %>
<jsp:include page="include/header.jsp"/>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    session.removeAttribute("login");
%>
<h1 class="text-center"><%= customer.getFirstName() %> has been logged out.</h1>
<jsp:include page="include/footer.jsp"/>
