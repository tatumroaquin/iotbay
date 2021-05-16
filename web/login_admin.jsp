
<%@page import = "model.Customer" %>
<%@page import = "controller.Validator" %>
<jsp:include page="include/header.jsp"/>
 
 <%
    String error_admin_email = (String) session.getAttribute("error_admin_email");
    String error_admin_pass  = (String) session.getAttribute("error_admin_pass");
    String error_admin_not_exist = (String) session.getAttribute("error_admin_not_exist");
    
    Validator validator = new Validator();
    validator.clearAdmin(session); // remove admin error strings*/
    
    String displayAdminEmailError    = "none";
    String displayAdminPasswordError = "none";
    String displayAdminNotExist      = "none";
    
    if (error_admin_not_exist != null) {
        displayAdminNotExist = "block";
    } else {
        displayAdminNotExist = "none";
    }
    
    if (error_admin_email != null) {
        displayAdminEmailError = "block";
    } else {
        displayAdminEmailError = "none";
    }
    
    if (error_admin_pass != null) {
        displayAdminPasswordError = "block";
    } else {
        displayAdminPasswordError = "none";
    }
%>
 
 <div class="container">
    <h1 class="text-center"> Admin Login </h1>
    <h2 class="text-center" style="color: red; display: <%= displayAdminEmailError %>;"><%= error_admin_email %></h2>
    <h2 class="text-center" style="color: red; display: <%= displayAdminPasswordError %>;"><%= error_admin_pass %></h2>
    <h2 class="text-center" style="color: red; display: <%= displayAdminNotExist %>;"><%= error_admin_not_exist %></h2>
    <form method="POST" action="LoginServletAdmin">
        
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
<jsp:include page="include/footer.jsp"/>
