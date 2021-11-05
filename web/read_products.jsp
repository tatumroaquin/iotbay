<%@page import = "model.Product"%>
<%@page import = "model.Customer"%>
<%@page import = "model.Staff"%>
<%@page import = "model.dao.DBManagerProduct" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.ListIterator" %>

<%
    DBManagerProduct DBManProduct = (DBManagerProduct) session.getAttribute("DBManProduct");
    Customer customer = (Customer) session.getAttribute("customer");
    Staff staff = (Staff) session.getAttribute("staff");
    String displayDeleteButton = "none";
    String displayAddCartButton = "inline-block";
    if(staff != null)
        displayDeleteButton = "inline-block";
    else
        displayDeleteButton = "none";
    
    ArrayList<Product> products = DBManProduct.fetchProducts();
    final int COL = 4;

    ArrayList<ArrayList<Product>> grid = new ArrayList();
    ArrayList<Product> chunk = new ArrayList();

    for (int i = 0; i < products.size(); i++) {
        if (i % COL < COL - 1) { // if index has the remainder of num-1 keep pushing inside the array.
            chunk.add(products.get(i));
        } else { // else if the remainder is zero push the chunk inside the newArr
            chunk.add(products.get(i));
            grid.add(chunk);
            chunk = new ArrayList();
        }
    }
    if (chunk.size() != 0) {
        grid.add(chunk);
     }%>

<%  ListIterator grid_iter = grid.listIterator();
    while (grid_iter.hasNext()) {
        ArrayList<Product> row = (ArrayList) grid_iter.next();
        ListIterator row_iter = row.listIterator();
        %><div class="row"><%
            while (row_iter.hasNext()) {
                Product product     = (Product) row_iter.next();
                int supplier_id     = product.getSupplier();
                String product_name = product.getName();
                int product_id      = DBManProduct.findProductId(supplier_id, product_name);
                int max_quantity    = product.getQuantity();%>
                <div class="col-md-3">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title"><%= product.getName()%></h5>
                            <p class="text-truncate"><%= product.getDesc()%></p>
                            <button class="btn btn-outline-warning" onclick="sub(<%= product_id %>, 1)">-</button>
                            <input type=number value=1 min=1 max=<%= max_quantity %> id="qty-<%= product_id %>" name="quantity">
                            <button class="btn btn-outline-warning" onclick="add(<%= product_id %>, <%= max_quantity %>)">+</button>
                            <button class="btn btn-outline-warning" onclick="addToCart(<%= supplier_id %>, <%= product_id %>, '<%= product_name %>')">Add to Cart</button>
                            <a  style="display: <%= displayDeleteButton %>;"
                                href="ServletProductDelete?supplier_id=<%= supplier_id %>&product_name=<%= product.getName()%>">
                                <button class="btn btn-outline-warning">Delete</button>
                            </a>
                        </div>
                    </div>
                </div>
          <%}
        %></div><br>
    <%}%>
<script>
   function add(pid, max) {
      let elem_id = `#qty-\${pid}`;
      let input = document.querySelector(elem_id);
      let quantity = input.value;
      if( quantity < max )
         ++input.value;
   }
   function sub(pid, min) {
      let elem_id = `#qty-\${pid}`;
      let input = document.querySelector(elem_id);
      let quantity = input.value;
      if( quantity > min )
         --input.value;
   }
   function getQuantity(pid) {
      let elem_id = `#qty-\${pid}`;
      let input = document.querySelector(elem_id);
      let quantity = input.value;
      return quantity;
   }
   function addToCart(sid, pid, pname) {
      let qty = getQuantity(pid);
      document.location.href=`ServletCartAdd?supplier_id=\${sid}&product_name=\${pname}&quantity=\${qty}`;
   }
   function subQuantity(pid, qty) {
       let elem_id = `#qty-\${pid}`;
       let input = document.querySelector(elem_id);
       input.max -= qty;
   }
 </script>

