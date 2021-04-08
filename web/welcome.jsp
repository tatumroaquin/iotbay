<%-- 
    Document   : welcome
    Created on : 30/03/2021, 7:23:37 PM
    Author     : ormus
--%>
<%@ page import = "model.Customer"%>
<jsp:include page="include/header.jsp"/>
    <%
        Customer customer = (Customer)session.getAttribute("customer");
        String message = "", loginEmail = "", loginPassword = "";
        if (session.getAttribute("login") != null) {
            message = "Welcome " + customer.getFirstName();
        } else {
            message = "you are not logged in.";
        }
        
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
        
        if(request.getParameter("login") != null) {
            loginEmail = request.getParameter("loginEmail");
            loginPassword = request.getParameter("loginPassword");
            
            if(loginEmail.equals(customer.getEmail())&& loginPassword.equals(customer.getPassword())) {
                session.setAttribute("login", 1);
            } else {
                message = "email or password invalid.";
            }
            
        }
           
    %>
    <h1 class="text-center"><%= message %></h1>
    <h2 class="text-center">req_email: <%= loginEmail %></h2>
    <h2 class="text-center">req_pass: <%= loginPassword %></h2>
    <h2 class="text-center">obj_email: <%= customer.getEmail() %></h2>
    <h2 class="text-center">obj_pass: <%= customer.getPassword() %></h2>
<jsp:include page="include/footer.jsp"/>
