
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer"%>
<%@page import="model.dao.*"%>

<jsp:include page="include/header.jsp"/>
 <h1 class="text-center"> Registration Form </h1>
 <div class="container">
    <form method="POST" action="register.jsp">

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
                <option selected>Choose...</option>
                <option value="sydney">Sydney</option>
                <option value="melbourne">Melbourne</option>
                <option value="adelaide">Adelaide</option>
                <option value="perth">Perth</option>
                <option value="brisbane">Brisbane</option>
                <option value="canberra">Canberra</option>
                <option value="hobart">Hobart</option>
                <option value="darwin">Darwin</option>
                <option value="goldcoast">Gold coast</option>
                <option value="wollongong">Wollongong</option>
                <option value="newcastle">Newcastle</option>
                <option value="cairns">Cairns</option>
             </select>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="state">State</label>
          <div class="col-sm-10">
             <select name="state" class="custom-select">
                <option selected>Choose...</option>
                <option value="NSW">New South Wales</option>
                <option value="NT">North Territory</option>
                <option value="QLD">Queensland</option>
                <option value="SA">South Australia</option>
                <option value="TAS">Tasmania</option>
                <option value="VIC">Victoria</option>
                <option value="WA">Western Australia</option>
             </select>
          </div>
       </div>

       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="postcode">PostCode</label>
          <div class="col-sm-10">
             <input type="text" name="postcode" placeholder="enter postcode" class="form-control"/>
          </div>
       </div>
        <input type="submit" name="submit" class="btn btn-outline-warning" value="Register"/>
    </form>
 </div>
<jsp:include page="include/footer.jsp"/>
