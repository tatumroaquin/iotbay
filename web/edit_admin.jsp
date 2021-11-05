<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Admin" %>
<%@page import = "model.City" %>
<%@page import = "model.State" %>
<%@page import = "model.dao.DBManagerAdmin" %>
<%@page import = "model.dao.DBManagerCity" %>
<%@page import = "model.dao.DBManagerState" %>
<%@page import = "controller.Validator" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.ListIterator" %>
<%
    Validator validator = new Validator();
    
    String error_admin_email = (String) session.getAttribute("error_admin_email");
    String error_admin_pass  = (String) session.getAttribute("error_admin_pass");
    String error_admin_not_exist = (String) session.getAttribute("error_admin_not_exist");

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
    
    Admin admin = (Admin) session.getAttribute("admin");
%>
<jsp:include page="include/header.jsp"/>
 <h1 class="text-center">Update Admin Details</h1>
 <h2 class="text-center" style="color: red; display: <%= displayAdminEmailError %>;"><%= error_admin_email %></h2>
 <h2 class="text-center" style="color: red; display: <%= displayAdminPasswordError %>;"><%= error_admin_pass %></h2>
 <h2 class="text-center" style="color: red; display: <%= displayAdminNotExist %>;"><%= error_admin_not_exist %></h2>

 <div class="container">
    <form method="POST" action="ServletAdminEdit">

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="email">Email</label>
          <div class="col-sm-10">
             <input type="text" name="email" value="<%= admin.getEmail() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="password">Password</label>
          <div class="col-sm-10">
             <input type="password" name="password" value="<%= admin.getPassword() %>" class="form-control"/>
          </div>
       </div>
        
        <div class="form-group row">
          <label class="col-form-label col-sm-2" for="mobile">Mobile</label>
          <div class="col-sm-10">
             <input type="text" name="mobile" value="<%= admin.getMobile() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="fname">First Name</label>
          <div class="col-sm-10">
             <input type="text" name="fname" value="<%= admin.getFirstName() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="lname">Last Name</label>
          <div class="col-sm-10">
             <input type="text" name="lname" value="<%= admin.getLastName() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="street">Street</label>
          <div class="col-sm-10">
             <input type="text" name="street" value="<%= admin.getStreet() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="city">City</label>
          <div class="col-sm-10">
             <select name="city" class="custom-select">
                <% 
                   DBManagerCity DBManCity = (DBManagerCity) session.getAttribute("DBManCity");
                   ArrayList<City> cities = DBManCity.fetchCities();
                   ListIterator<City> cities_iter = cities.listIterator();
                %>
                <% while(cities_iter.hasNext()) {
                    City city = (City) cities_iter.next();
                    String param = admin.getCity();
                     if (param.equals(city.getName())) { %>
                        <option selected><%= city.getName() %></option>
                   <%} else {%>
                        <option value="<%= city.getName() %>"><%= city.getName() %></option>
                   <%}%>
                 <%}%>
             </select>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="state">State</label>
          <div class="col-sm-10">
             <select name="state" class="custom-select">
                <%
                 DBManagerState DBManState = (DBManagerState) session.getAttribute("DBManState");
                 ArrayList<State> states = DBManState.fetchStates();
                 ListIterator<State> states_iter = states.listIterator();
                %>
                <% while(states_iter.hasNext()) {
                    State state = (State) states_iter.next();
                    String param = admin.getState();
                    if (param.equals(state.getAcronym())) { %>
                        <option selected value="<%= state.getAcronym() %>"><%= state.getFullName() %></option>
                  <%} else {%>
                        <option value="<%= state.getAcronym() %>"><%= state.getFullName() %></option>
                  <%}%>
                <%}%>
             </select>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="postcode">PostCode</label>
          <div class="col-sm-10">
             <input type="text" name="postcode" value="<%= admin.getPostCode() %>" class="form-control"/>
          </div>
       </div>
       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="country">Country</label>
          <div class="col-sm-10">
             <select name="country" class="custom-select">
                 <option selected value="<%= admin.getCountry() %>"><%= admin.getCountry() %></option>
             </select>
          </div>
       </div>
       <input type="submit" name="submit" class="btn btn-outline-warning" value="Edit"/>
    </form>
                 <a href="DeleteServletAdmin">
                     <button class="btn btn-outline-warning">Delete Account</button>
                 </a>
 </div>
<jsp:include page="include/footer.jsp"/>
