<%@page import = "controller.Validator" %>
<jsp:include page="include/header.jsp"/>
 
 <%
    String error_staff_email = (String) session.getAttribute("error_staff_email");
    String error_staff_pass  = (String) session.getAttribute("error_staff_pass");
    String error_staff_not_exist = (String) session.getAttribute("error_staff_not_exist");
    
    Validator validator = new Validator();
    validator.clearStaff(session); // remove staff error strings*/
    
    String displayStaffEmailError    = "none";
    String displayStaffPasswordError = "none";
    String displayStaffNotExist      = "none";
    
    if (error_staff_not_exist != null) {
        displayStaffNotExist = "block";
    } else {
        displayStaffNotExist = "none";
    }
    
    if (error_staff_email != null) {
        displayStaffEmailError = "block";
    } else {
        displayStaffEmailError = "none";
    }
    
    if (error_staff_pass != null) {
        displayStaffPasswordError = "block";
    } else {
        displayStaffPasswordError = "none";
    }
%>
 
 <div class="container">
    <h1 class="text-center"> Staff Login </h1>
    <h2 class="text-center" style="color: red; display: <%= displayStaffEmailError %>;"><%= error_staff_email %></h2>
    <h2 class="text-center" style="color: red; display: <%= displayStaffPasswordError %>;"><%= error_staff_pass %></h2>
    <h2 class="text-center" style="color: red; display: <%= displayStaffNotExist %>;"><%= error_staff_not_exist %></h2>
    <form method="POST" action="ServletStaffLogin">
        
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