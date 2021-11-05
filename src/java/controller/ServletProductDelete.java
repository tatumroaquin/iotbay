package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import model.*;
import model.dao.DBManagerProduct;
public class ServletProductDelete extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session            = request.getSession();
        Validator validator            = new Validator();
        DBManagerProduct DBManProduct  = (DBManagerProduct) session.getAttribute("DBManProduct");
        int supplier_id                = Integer.parseInt(request.getParameter("supplier_id"));
        String name                    = request.getParameter("product_name");
        
        System.out.println("PRODUCT NAME: "+name);
        validator.clear(session);
        try {
            DBManProduct.deleteProduct(supplier_id, name);
            request.getRequestDispatcher("index.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletProductDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
