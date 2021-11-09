<%-- 
    Document   : navbar
    Created on : 07/04/2021, 1:45:47 PM
    Author     : ormus
--%>
<%@ page import = "model.Admin"%>
<%@ page import = "model.Customer"%>
<%@ page import = "model.Staff"%>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    Staff staff = (Staff) session.getAttribute("staff");
    Admin admin = (Admin) session.getAttribute("admin");
    
    String displayLogin         = "inline-block";
    String displayButtons       = "none";
    String displayUALCustomer   = "none";
    String displayUALStaff      = "none";
    String displayUALAdmin      = "none";
    
    String displayEditCustomer  = "none";
    String displayEditStaff     = "none";
    String displayEditAdmin     = "none";
    
    String displayCreateProduct    = "none";
    if(admin != null || customer != null || staff != null)
    {
        displayLogin = "none";
        displayButtons = "inline-block";
    } else {
        displayLogin = "inline-block";
        displayButtons = "none";
    }
    
    if(customer != null) {
        displayUALCustomer = "inline-block";
        displayEditCustomer = "inline-block";
    } else if (staff != null) {
        displayUALStaff = "inline-block";
        displayEditStaff = "inline-block";
        displayCreateProduct = "inline-block";
    } else if (admin != null) {
        displayUALAdmin = "inline-block";
        displayEditAdmin = "inline-block";
    }
%>
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom justify-content-between">
  <a class="navbar-brand" href="index.jsp">
     <img src="image/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
     IoTbay
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle Navigation">
     <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
     <ul class="navbar-nav mr-auto">
        <li class="nav-item" class="navbar-item active">
           <a class="nav-link" href="index.jsp">Index</a>
        </li>
        <li class="nav-item" class="nav-item" style="display: <%= displayCreateProduct %>;">
           <a class="nav-link" href="create_product.jsp">Add Products</a>
        </li>
        <li class="nav-item" class="nav-item">
           <a class="nav-link" href="register.jsp">Register</a>
        </li>
        <li class="nav-item" class="nav-item" style="display: <%= displayLogin %>;">
           <a class="nav-link" href="login.jsp">Login</a>
        </li>
        <li class="nav-item" style="display: <%= displayUALCustomer%>;">
           <a class="nav-link" href="ual_customer.jsp">UAL Customer</a>
        </li>
        <li class="nav-item" style="display: <%= displayUALStaff%>;">
           <a class="nav-link" href="ual_staff.jsp">UAL Staff</a>
        </li>
        <li class="nav-item" style="display: <%= displayUALAdmin%>;">
           <a class="nav-link" href="ual_admin.jsp">UAL Admin</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="cart.jsp">Cart</a>
        </li>
     </ul>
     <ul class="navbar-nav ml-auto">
        <li class="nav-item" style="float: right; display: <%= displayButtons %>;">
           <table>
               <tr>
                   <td style="display: <%= displayEditCustomer %>;">
                       <a class="nav-link" href="edit_customer.jsp">
                           <button class="btn btn-outline-warning">Customer Account</button>
                       </a>
                   </td>
                   <td style="display: <%= displayEditStaff %>;">
                       <a class="nav-link" href="edit_staff.jsp">
                           <button class="btn btn-outline-warning">Staff Account</button>
                       </a>
                   </td>
                   <td style="display: <%= displayEditAdmin %>;">
                       <a class="nav-link" href="edit_admin.jsp">
                           <button class="btn btn-outline-warning">Admin Account</button>
                       </a>
                   </td>
                   <td>
                       <a class="nav-link" href="ServletLogout">
                           <button class="btn btn-outline-warning">Logout</button>
                       </a>
                   </td>
                </tr>
           </table>
        </li>
     </ul>
  </div>
</nav>
