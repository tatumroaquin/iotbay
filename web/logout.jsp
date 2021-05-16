<jsp:include page="include/header.jsp"/>
<%@ page import = "model.Admin"%>
<%@ page import = "model.Customer"%>
<%@ page import = "model.Staff"%>
<%
    String firstName = "first";
    String lastName  = "last";
    
    Customer customer = (Customer) session.getAttribute("customer");
    Staff staff = (Staff) session.getAttribute("staff");
    Admin admin = (Admin) session.getAttribute("admin");
    
    if (customer != null) {
        firstName = customer.getFirstName(); 
        lastName = customer.getLastName();
    } else if (staff != null) {
        firstName = staff.getFirstName(); 
        lastName = staff.getLastName();
    } else if (admin != null) {
        firstName = admin.getFirstName(); 
        lastName = admin.getLastName();
    }
    
    session.invalidate();
%>
<h1 class="text-center"> <%= firstName %> <%= lastName %> has been logged out.</h1>
<jsp:include page="include/footer.jsp"/>
