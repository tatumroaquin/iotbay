<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.ListIterator" %>
<%@page import = "model.Product" %>
<jsp:include page="/ServletCartInit"/>
<jsp:include page="include/header.jsp"/>
<%
    ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
    ListIterator cart_iter = cart.listIterator();
%>
<div class="container">
    <table class="text-center mx-auto" width="50%">
    <% float total = 0.00f; %>
        <tr>
            <th><strong>Name</strong></th>
            <th><strong>Price</strong></th>
            <th><strong>Quantity</strong></th>
            <th><strong>Action</strong></th>
        </tr>
    <%
        while(cart_iter.hasNext()) {
            Product product = (Product) cart_iter.next();
            
            String name     = product.getName();
            float price     = product.getPrice();
            int quantity    = product.getQuantity();
            int supplier_id = product.getSupplier();
            total += price * quantity;
            %>
            <tr>
                <td><%= name %></td>
                <td><%= price %></td>
                <td><%= quantity %></td>
                <td><a href="ServletCartDelete?supplier_id=<%=supplier_id%>&product_name=<%=name%>">
                        <button class="btn btn-outline-warning">Remove</button>
                    </a>
                </td>
            </tr>
            <%
        }
    %>
    <%String displayCheckoutButton = "block";
      if (cart.isEmpty()) {
          displayCheckoutButton = "none";
      }
    %>
        <tr>
            <th>Total</th>
            <td><%= total %></td>
            <td></td>
            <td style="display: <%= displayCheckoutButton %>">
                <a href="#">
                    <button class="btn btn-outline-warning">Checkout</button>
                </a>
            </td>
        </tr>
        
    </table>
</div>
<jsp:include page="include/footer.jsp"/>
