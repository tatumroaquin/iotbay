<%-- 
    Document   : index
    Created on : 29/03/2021, 5:18:09 AM
    Author     : ormus
--%>
<%@ page import = "model.Customer"%>
<jsp:include page="include/header.jsp"/>
       <h1 class="text-center">Main Page</h1>
       <%
           Customer customer = (Customer)session.getAttribute("customer");
           if (customer == null) customer = new Customer();
       %>
       <div class="container">
      <table width = "100%">
         <tr>
            <th>Email</th>
            <th>Password</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Street</th>
            <th>City</th>
            <th>State</th>
            <th>PostCode</th>
         </tr>
         <tr>
            <td><%= customer.getEmail() %></td>
            <td><%= customer.getPassword() %></td>
            <td><%= customer.getFirstName() %></td>
            <td><%= customer.getLastName() %></td>
            <td><%= customer.getStreet() %></td>
            <td><%= customer.getCity() %></td>
            <td><%= customer.getState() %></td>
            <td><%= customer.getPostCode() %></td>
     
         </tr>
       
      </table>
       </div>
<jsp:include page="include/footer.jsp"/>