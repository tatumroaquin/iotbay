<%@page import = "model.Product"%>
<%@page import = "model.Customer"%>
<%@page import = "model.Staff"%>
<%@page import = "model.dao.DBManager" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.ListIterator" %>

<%
    DBManager manager = (DBManager) session.getAttribute("manager");
    Customer customer = (Customer) session.getAttribute("customer");
    Staff staff = (Staff) session.getAttribute("staff");
    String displayDeleteButton = "none";
    String displayAddCartButton = "inline-block";
    if(staff != null)
        displayDeleteButton = "inline-block";
    else
        displayDeleteButton = "none";
    
    ArrayList<Product> products = manager.fetchProducts();
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
    if (chunk.size() != 0) { // if chunk array is not empty push it's contents inside the newArr.
        grid.add(chunk);
    }

    ListIterator grid_iter = grid.listIterator();
    while (grid_iter.hasNext()) {
        ArrayList<Product> row = (ArrayList) grid_iter.next();
        ListIterator row_iter = row.listIterator();
        %><div class="row"><%
            while (row_iter.hasNext()) {
                Product product = (Product) row_iter.next();
                int supplier_id = product.getSupplier();%>
                <div class="col-md-3">
                    <div class="card text-center">
                        <div class="card-body">
                            <h5 class="card-title"><%= product.getName()%></h5>
                            <p class="text-truncate"><%= product.getDesc()%></p>
                            <!--<a  style="display:  displayAddCartButton %>;"
                                href="AddToCartServlet?supplier_id= supplier_id %>&product_name= product.getName()%>">
                                <button class="btn btn-outline-warning">Add to Cart</button>
                            </a>-->
                            <a  style="display: <%= displayAddCartButton %>;"
                                href="addcart.jsp">
                                 <button class="btn btn-outline-warning">Add to Cart</button>
                            </a>
                            <a  style="display: <%= displayDeleteButton %>;"
                                href="DeleteServletProduct?supplier_id=<%= supplier_id %>&product_name=<%= product.getName()%>">
                                <button class="btn btn-outline-warning">Delete</button>
                            </a>
                        </div>
                    </div>
                </div>
          <%}
        %></div><br>
    <%}
%>