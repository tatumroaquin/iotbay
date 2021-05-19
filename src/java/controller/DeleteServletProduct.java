package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
import model.dao.DBManager;
public class DeleteServletProduct extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        DBManager manager   = (DBManager) session.getAttribute("manager");
        int supplier_id     = Integer.parseInt(request.getParameter("supplier_id"));
        String name         = request.getParameter("product_name");
        
        System.out.println("PRODUCT NAME: "+name);
        validator.clear(session);
        try {
            manager.deleteProduct(supplier_id, name);
            request.getRequestDispatcher("index.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteServletProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
