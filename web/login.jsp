<%-- 
    Document   : login
    Created on : 09/04/2021, 03:58:00 AM
    Author     : ormus
--%>
<jsp:include page="include/header.jsp"/>
 <h1 class="text-center"> Login Form </h1>
 <div class="container">
    <form method="POST" action="welcome.jsp">

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