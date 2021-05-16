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
    } else if (admin != null) {
        displayUALAdmin = "inline-block";
        displayEditAdmin = "inline-block";
    }
%>
<div class="container">
    <img src="image/logo.png" alt="logo" class="logo"/>
    <h1 class="nav-title">IoTBay</h1>
    <nav>
        <ul>
           <li>
              <a href="index.jsp">Index</a>
           </li>
           <li>
              <a href="main.jsp">Main</a>
           </li>
           <li>
              <a href="register.jsp">Register</a>
           </li>
           <li style="display: <%= displayLogin %>;">
              <a href="login.jsp">Login</a>
           </li>
           <li style="display: <%= displayUALCustomer%>;">
              <a href="ual_customer.jsp">UAL Customer</a>
           </li>
           <li style="display: <%= displayUALStaff%>;">
              <a href="ual_staff.jsp">UAL Staff</a>
           </li>
           <li style="display: <%= displayUALAdmin%>;">
              <a href="ual_admin.jsp">UAL Admin</a>
           </li>
           <li style="float: right; display: <%= displayButtons %>;">
               <table>
                   <tr>
                       <td style="display: <%= displayEditCustomer %>;">
                           <a href="edit_customer.jsp">
                               <button class="btn btn-outline-warning">Customer Account</button>
                           </a>
                       </td>
                       <td style="display: <%= displayEditStaff %>;">
                           <a href="edit_staff.jsp">
                               <button class="btn btn-outline-warning">Staff Account</button>
                           </a>
                       </td>
                       <td style="display: <%= displayEditAdmin %>;">
                           <a href="edit_admin.jsp">
                               <button class="btn btn-outline-warning">Admin Account</button>
                           </a>
                       </td>
                       <td>
                           <a href="LogoutServlet">
                               <button class="btn btn-outline-warning">Logout</button>
                           </a>
                       </td>
                    </tr>
               </table>
           </li>
        </ul>
    </nav>
</div>
