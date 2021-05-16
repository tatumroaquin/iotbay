<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.City" %>
<%@page import = "model.State" %>
<%@page import = "model.dao.DBManager" %>
<%@page import = "controller.Validator" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.ListIterator" %>
<jsp:include page="include/header.jsp"/>
 <%
    Validator validator = new Validator();
    
    String error_staff_email = (String) session.getAttribute("error_staff_email");
    String error_staff_pass  = (String) session.getAttribute("error_staff_pass");
    String error_staff_not_exist = (String) session.getAttribute("error_staff_not_exist");

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
<h1 class="text-center">Staff Registration</h1>
<h2 class="text-center" style="color: red; display: <%= displayStaffEmailError %>;"><%= error_staff_email %></h2>
<h2 class="text-center" style="color: red; display: <%= displayStaffPasswordError %>;"><%= error_staff_pass %></h2>
<h2 class="text-center" style="color: red; display: <%= displayStaffNotExist %>;"><%= error_staff_not_exist %></h2>
 <div class="container">
    <form method="POST" action="RegisterServletStaff">

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
        
       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="mobile">Mobile</label>
          <div class="col-sm-10">
             <input type="text" name="mobile" placeholder="enter mobile" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="fname">First Name</label>
          <div class="col-sm-10">
             <input type="text" name="fname" placeholder="enter firstname" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="lname">Last Name</label>
          <div class="col-sm-10">
             <input type="text" name="lname" placeholder="enter lastname" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="street">Street</label>
          <div class="col-sm-10">
             <input type="text" name="street" placeholder="enter street" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="city">City</label>
          <div class="col-sm-10">
             <select name="city" class="custom-select">
             <% 
                   DBManager manager = (DBManager) session.getAttribute("manager");
                   ArrayList<City> cities = manager.fetchCities();
                   ListIterator<City> cities_iter = cities.listIterator();
             %>
                <option selected>Choose...</option>
                <% while(cities_iter.hasNext()) { %>
                <% City city = (City) cities_iter.next(); %>
                    <option value="<%= city.getName() %>"><%= city.getName() %></option>
                <% } %>
             </select>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="state">State</label>
          <div class="col-sm-10">
             <select name="state" class="custom-select">
             <%
                 ArrayList<State> states = manager.fetchStates();
                 ListIterator<State> states_iter = states.listIterator();
             %>
                <option selected>Choose...</option>
                <% while(states_iter.hasNext()) { %>
                <% State state = (State) states_iter.next(); %>
                    <option value="<%= state.getAcronym() %>"><%= state.getFullName() %></option>
                <% } %>
             </select>
          </div>
       </div>
       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="postcode">PostCode</label>
          <div class="col-sm-10">
             <input type="text" name="postcode" placeholder="enter postcode" class="form-control"/>
          </div>
       </div>
       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="country">Country</label>
          <div class="col-sm-10">
             <select name="country" class="custom-select">
                 <option selected>Choose...</option>
                 <option value="Australia">Australia</option>
             </select>
          </div>
       </div>
       <input type="submit" name="submit" class="btn btn-outline-warning" value="Register"/>
    </form>
 </div>
<jsp:include page="include/footer.jsp"/>
