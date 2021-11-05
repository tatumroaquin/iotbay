package controller;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.*;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import model.dao.DBManagerProduct;
public class ServletCartAdd extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManagerProduct DBManProduct = (DBManagerProduct) session.getAttribute("DBManProduct");
        Validator validator = new Validator();
        validator.clear(session);
        
        String product_name = request.getParameter("product_name");
        int supplier_id     = Integer.parseInt(request.getParameter("supplier_id"));
        int quantity        = Integer.parseInt(request.getParameter("quantity"));
        
        try {
            Product product = DBManProduct.findProduct(supplier_id, product_name);
            int product_id  = DBManProduct.findProductId(supplier_id, product_name);
            product.setQuantity(quantity);
            
            @SuppressWarnings("unchecked")
            ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
            ListIterator cart_iter  = cart.listIterator();
            
            boolean productNotExistInCart = true;
            while(cart_iter.hasNext()) {
                Product item = (Product) cart_iter.next();
                if (item.getName().equals(product.getName())) {
                    productNotExistInCart = false;
                    request.setAttribute("item_exist",  product_name+" is already in cart!");
                    break;
                }
            }
            
            if(productNotExistInCart) {
                cart.add(product);
                session.setAttribute("cart", cart);
            }
            
            request.getRequestDispatcher("index.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProductDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
