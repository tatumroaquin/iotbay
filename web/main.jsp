
<%@ page import = "model.Customer"%>
<jsp:include page="include/header.jsp"/>

<%
    Customer customer = (Customer) session.getAttribute("customer");
%>

        <h1 class="text-center">Main Page</h1>
        <h2 class="text-center" style="display: block"> message </h2>
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
       
      </table>
       </div>
<jsp:include page="include/footer.jsp"/>