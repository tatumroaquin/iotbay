<%-- 
    Document   : login
    Created on : 09/04/2021, 03:58:00 AM
    Author     : ormus
--%>
<%@ page import = "model.Customer" %>
<jsp:include page="include/header.jsp"/>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    String success = "none", failure = "none";
    if(request.getParameter("login") != null) {
            String loginEmail = request.getParameter("loginEmail");
            String loginPassword = request.getParameter("loginPassword");
            if(loginEmail.equals(customer.getEmail()) && loginPassword.equals(customer.getPassword())) {
                String message = "Welcome " + customer.getFirstName();
                session.setAttribute("login", message);
                success = "block";
                failure = "none";
            } else {
                String message = "email or password invalid.";
                session.setAttribute("login", message);
                success = "none";
                failure = "block";
            }
        }
%>
 <h1 class="text-center"> Login Form </h1>
 <h2 class="text-center" style="display: <%= success %>;"> Logged <%= customer.getFirstName() %> </h2>
 <h2 class="text-center" style="color: red; display: <%= failure %>;"> check your details again </h2>
 <div class="container">
    <form method="POST" action="login.jsp">

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="email">Email</label>
          <div class="col-sm-10">
             <input type="text" name="loginEmail" placeholder="enter email" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="password">Password</label>
          <div class="col-sm-10">
             <input type="password" name="loginPassword" placeholder="enter password" class="form-control"/>
          </div>
       </div>

        <input type="submit" name="login" class="btn btn-outline-warning" value="Login"/>

    </form>
 </div>
<jsp:include page="include/footer.jsp"/>