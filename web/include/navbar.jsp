<%-- 
    Document   : navbar
    Created on : 07/04/2021, 1:45:47 PM
    Author     : ormus
--%>
<%@ page import = "model.Customer"%>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    String status = "";
    if (customer == null || session.getAttribute("login") == null)
        status = "none";
    else
        status = "block";
%>
<div class="container">
    <img src="image/logo.png" alt="logo" class="logo"/>
    <h1 class="nav-title">IoTBay</h1>
    <nav>
        <ul>
           <li>
              <a href="index.jsp">Index / Interface</a>
           </li>
           <li>
              <a href="main.jsp">Main</a>
           </li>
           <li>
              <a href="register.jsp">Register</a>
           </li>
           <li>
              <a href="login.jsp">Login</a>
           </li>
           <li>
              <a href="welcome.jsp">Welcome</a>
           </li>
           <li style="float: right; display: <%= status %>;">
               <table>
                   <tr>
                       <td><button onclick="location.href = 'edit.jsp'" class="btn btn-outline-warning">Edit</button></td>
                       <td><button onclick="location.href = 'logout.jsp'" class="btn btn-outline-warning">Logout</button></td>
                    </tr>
               </table>
           </li>
        </ul>
    </nav>
</div>
