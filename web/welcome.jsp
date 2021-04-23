
<%@ page import = "model.Customer"%>
<jsp:include page="include/header.jsp"/>
    <%
        Customer customer = (Customer)session.getAttribute("customer");
        String message = String.valueOf(session.getAttribute("login"));
        
        if(request.getParameter("submit") != null) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String postCode = request.getParameter("postcode");
            
            Customer newCustomer = new Customer(email, password, firstName, lastName, street, city, state, postCode);
            session.setAttribute("customer", newCustomer);
        }
        
        if(message == "null") {
            message = "You are not logged in.";
        }
    %>
    <h1 class="text-center"><%= message %></h1>
<jsp:include page="include/footer.jsp"/>
