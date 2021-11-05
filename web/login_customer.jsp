<%@page import = "controller.Validator" %>
<jsp:include page="include/header.jsp"/>

<%
    Validator validator = new Validator();
    
    String error_customer_email = (String) session.getAttribute("error_customer_email");
    String error_customer_pass  = (String) session.getAttribute("error_customer_pass");
    String error_customer_not_exist = (String) session.getAttribute("error_customer_not_exist");

    validator.clearCustomer(session); // remove customer error strings*/
    
    String displayCustomerEmailError    = "none";
    String displayCustomerPasswordError = "none";
    String displayCustomerNotExist      = "none";
    
    if (error_customer_not_exist != null) {
        displayCustomerNotExist = "block";
    } else {
        displayCustomerNotExist = "none";
    }
    
    if (error_customer_email != null) {
        displayCustomerEmailError = "block";
    } else {
        displayCustomerEmailError = "none";
    }
    
    if (error_customer_pass != null) {
        displayCustomerPasswordError = "block";
    } else {
        displayCustomerPasswordError = "none";
    }
%>

 <h1 class="text-center"> Customer Login </h1>
 <h2 class="text-center" style="color: red; display: <%= displayCustomerEmailError %>;"><%= error_customer_email %></h2>
 <h2 class="text-center" style="color: red; display: <%= displayCustomerPasswordError %>;"><%= error_customer_pass %></h2>
 <h2 class="text-center" style="color: red; display: <%= displayCustomerNotExist %>;"><%= error_customer_not_exist %></h2>
 
 <div class="container">
    <form method="POST" action="ServletCustomerLogin">
        
       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="email">Email</label>
          <div class="col-sm-10">
             <input type="text" name="email" placeholder="enter email" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="password">Password</label>
          <div class="col-sm-10">
             <input type="password" name="password" placeholder="enter password" class="form-control"/>
          </div>
       </div>

       <input type="submit" name="login" class="btn btn-outline-warning" value="Login"/>
    </form>
 </div>