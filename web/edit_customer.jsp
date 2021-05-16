<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.Customer" %>
<%@page import = "model.City" %>
<%@page import = "model.State" %>
<%@page import = "model.dao.DBManager" %>
<%@page import = "controller.Validator" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.ListIterator" %>
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
    
    Customer customer = (Customer) session.getAttribute("customer");
%>
<jsp:include page="include/header.jsp"/>
 <h1 class="text-center">Update Customer Details</h1>
 <h2 class="text-center" style="color: red; display: <%= displayCustomerEmailError %>;"><%= error_customer_email %></h2>
 <h2 class="text-center" style="color: red; display: <%= displayCustomerPasswordError %>;"><%= error_customer_pass %></h2>
 <h2 class="text-center" style="color: red; display: <%= displayCustomerNotExist %>;"><%= error_customer_not_exist %></h2>

 <div class="container">
    <form method="POST" action="EditServletCustomer">

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="email">Email</label>
          <div class="col-sm-10">
             <input type="text" name="email" placeholder="<%= customer.getEmail() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="password">Password</label>
          <div class="col-sm-10">
             <input type="password" name="password" placeholder="<%= customer.getPassword() %>" class="form-control"/>
          </div>
       </div>
        
        <div class="form-group row">
          <label class="col-form-label col-sm-2" for="mobile">Mobile</label>
          <div class="col-sm-10">
             <input type="text" name="mobile" placeholder="<%= customer.getMobile() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="fname">First Name</label>
          <div class="col-sm-10">
             <input type="text" name="fname" placeholder="<%= customer.getFirstName() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="lname">Last Name</label>
          <div class="col-sm-10">
             <input type="text" name="lname" placeholder="<%= customer.getLastName() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="street">Street</label>
          <div class="col-sm-10">
             <input type="text" name="street" placeholder="<%= customer.getStreet() %>" class="form-control"/>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="city">City</label>
          <div class="col-sm-10">
             <select name="city" class="custom-select">
                <% 
                   DBManager manager = (DBManager) session.getAttribute("manager");
                   ArrayList<City> cities = manager.fetchCities();
                   ListIterator<City> iter = cities.listIterator();
                %>
                <option selected><%= customer.getCity()%></option>
                <% while(iter.hasNext()) { %>
                <% City city = (City) iter.next(); %>
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
                <option disabled selected><%= customer.getState()%></option>
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
             <input type="text" name="postcode" placeholder="<%= customer.getPostCode() %>" class="form-control"/>
          </div>
       </div>
       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="country">Country</label>
          <div class="col-sm-10">
             <select name="country" class="custom-select">
                 <option disabled selected><%= customer.getCountry() %></option>
                 <option value="Australia">Australia</option>
             </select>
          </div>
       </div>
       <input type="submit" name="submit" class="btn btn-outline-warning" value="Edit"/>
    </form>
                 <a href="DeleteServletCustomer">
                     <button class="btn btn-outline-warning">Delete Account</button>
                 </a>
 </div>
<jsp:include page="include/footer.jsp"/>
