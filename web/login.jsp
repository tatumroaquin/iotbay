<jsp:include page="include/header.jsp"/>

<div class="row">
  <div class="col-md-4">
     <div class="card text-center mx-auto" style="width: 18rem;">
        <img class="card-img-top" src="image/admin-icon.png">
        <div class="card-body">
           <h5 class="card-title">Admin</h5>
           <a href="login_admin.jsp">
              <button class="btn btn-outline-warning">Login</button>
           </a>
        </div>
     </div>
  </div>

  <div class="col-md-4">
     <div class="card text-center mx-auto" style="width: 18rem;">
        <img class="card-img-top" src="image/staff-icon.png">
        <div class="card-body">
           <h5 class="card-title">Staff</h5>
           <a href="login_staff.jsp">
               <button class="btn btn-outline-warning">Login</button>
           </a>
        </div>
     </div>
  </div>

  <div class="col-md-4">
     <div class="card text-center mx-auto" style="width: 18rem;">
        <img class="card-img-top" src="image/customer-icon.png">
        <div class="card-body">
           <h5 class="card-title">Customer</h5>
           <a href="login_customer.jsp">
              <button class="btn btn-outline-warning">Login</button>
           </a>
        </div>
     </div>
  </div>
</div>
<jsp:include page="include/footer.jsp"/>
