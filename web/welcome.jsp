<jsp:include page="include/header.jsp"/>
<%@page import = "model.Admin" %>
<%@page import = "model.Customer" %>
<%@page import = "model.Staff" %>
<%
    Admin admin       = (Admin) session.getAttribute("admin");
    Customer customer = (Customer) session.getAttribute("customer");
    Staff staff       = (Staff) session.getAttribute("staff");
    
    String firstName = "", lastName = "";
    if(customer != null) {
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
    } else if (staff != null) {
        firstName = staff.getFirstName();
        lastName = staff.getLastName();
    } else if (admin != null) {
        firstName = admin.getFirstName();
        lastName = admin.getLastName();
    }
    
%>
    <h1 class="text-center">Welcome <%= firstName %> <%= lastName %> </h1>
<jsp:include page="include/footer.jsp"/>
