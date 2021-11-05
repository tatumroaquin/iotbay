package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import model.dao.DBManagerProduct;
public class ServletCartDelete extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManagerProduct DBManProduct = (DBManagerProduct) session.getAttribute("DBManProduct");
        Validator validator = new Validator();
        validator.clear(session);
        
        String product_name = request.getParameter("product_name");
        int supplier_id     = Integer.parseInt(request.getParameter("supplier_id"));
        
        try {
            Product product = DBManProduct.findProduct(supplier_id, product_name);
            Object object = session.getAttribute("cart");
            
            if (object instanceof ArrayList) {
                ArrayList<?> cart = (ArrayList<?>) object;
                ListIterator cart_iter = cart.listIterator();
                while(cart_iter.hasNext()) {
                    Product item = (Product) cart_iter.next();
                    String item_name = item.getName();
                    if (item_name.equals(product.getName())) {
                        cart.remove(item);
                        break;
                    }
                }
                session.setAttribute("cart", cart);
                request.getRequestDispatcher("cart.jsp").include(request, response);
            } else {
                request.getRequestDispatcher("cart.jsp").include(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletProductDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
