<jsp:include page="include/header.jsp"/>

<div class="row padding-top-sm" >
  <div class="col-md-6">
     <div class="card text-center mx-auto padding-top-sm" style="width: 18rem;">
        <img class="card-img-top" src="image/staff-icon.png">
        <div class="card-body">
           <h5 class="card-title">Staff</h5>
           <a href="register_staff.jsp">
               <button class="btn btn-outline-warning">Register</button>
           </a>
        </div>
     </div>
  </div>

  <div class="col-md-6">
     <div class="card text-center mx-auto padding-top-sm" style="width: 18rem;">
        <img class="card-img-top" src="image/customer-icon.png">
        <div class="card-body">
           <h5 class="card-title">Customer</h5>
           <a href="register_customer.jsp">
              <button class="btn btn-outline-warning">Register</button>
           </a>
        </div>
     </div>
  </div>
</div>
<jsp:include page="include/footer.jsp"/>
