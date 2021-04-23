
<%@page import = "model.Customer" %>
<jsp:include page="include/header.jsp"/>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    session.removeAttribute("login");
%>
<h1 class="text-center"><%= customer.getFirstName() %> has been logged out.</h1>
<jsp:include page="include/footer.jsp"/>
