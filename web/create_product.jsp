<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.ListIterator" %>
<%@page import = "controller.Validator" %>
<%@page import = "model.Supplier" %>
<%@page import = "model.dao.DBManagerSupplier" %>
<jsp:include page="include/header.jsp"/>

<%
    
    String error_product_exist = (String) session.getAttribute("error_product_exist");
    String displayProductExist = "none";
    
    Validator validator = new Validator();
    validator.clearProduct(session);
    
    if(error_product_exist != null) {
        displayProductExist = "block";
    } else {
        displayProductExist = "none";
    }
%>

<h1 class="text-center">Add Product</h1>
<h2 class="text-center" style="color: red; display: <%= displayProductExist %>;"><%= error_product_exist %></h2>
<div class="container">
    <form method="POST" action="ServletProductCreate">
        <div class="form-group row">
          <label class="col-form-label col-sm-2" for="name">Product Name</label>
          <div class="col-sm-10">
             <input type="text" name="name" placeholder="enter product name" class="form-control"/>
          </div>
       </div>
        <div class="form-group row">
          <label class="col-form-label col-sm-2" for="price">Product Price</label>
          <div class="col-sm-10">
             <input type="number" step="0.01" name="price" placeholder="enter product price" class="form-control"/>
          </div>
       </div>
        <div class="form-group row">
          <label class="col-form-label col-sm-2" for="quantity">Product Quantity</label>
          <div class="col-sm-10">
             <input type="number" name="quantity" placeholder="enter product quantity" class="form-control"/>
          </div>
       </div>
       <div class="form-group row">
          <label class="col-form-label col-sm-2" for="supplier">Supplier</label>
          <div class="col-sm-10">
             <select name="supplier" class="custom-select">
                 
                <% 
                   DBManagerSupplier DBManSupplier = (DBManagerSupplier) session.getAttribute("DBManSupplier");
                   ArrayList<Supplier> suppliers = DBManSupplier.fetchSuppliers();
                   ListIterator<Supplier> suppliers_iter = suppliers.listIterator();
                %>
                <option selected>Choose...</option>
                <% while(suppliers_iter.hasNext()) {
                    Supplier supplier = (Supplier) suppliers_iter.next();
                    int supplier_id = DBManSupplier.findSupplierId(supplier.getCompanyName(), supplier.getEmail());
                    String supplierOption = "("+supplier.getCompanyName()+") "+supplier.getFirstName()+" "+supplier.getLastName();
                %>
                    <option value="<%= supplier_id %>"><%= supplierOption %></option>
                <% } %>

             </select>
          </div>
       </div>
        <div class="form-group row">
          <label class="col-form-label col-sm-2" for="description">Product Description</label>
          <div class="col-sm-10">
             <input type="textarea" name="description" placeholder="enter product description" class="form-control"/>
          </div>
       </div>
       <input type="submit" name="submit" value="Add Product" class="btn btn-outline-warning">
    </form>
</div>
<jsp:include page="include/footer.jsp"/>
