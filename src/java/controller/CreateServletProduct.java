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

public class CreateServletProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");

        String name        = request.getParameter("name");
        float price        = Float.parseFloat(request.getParameter("price"));
        int supplier_id    = Integer.parseInt(request.getParameter("supplier"));
        int quantity       = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");

        try {
            Product product = manager.findProduct(supplier_id, name);
            if (product != null) {
                session.setAttribute("error_product_exist", "Product already exists!");
                System.out.println("exist error called");
                request.getRequestDispatcher("create_product.jsp").include(request, response);
            } else {
                manager.createProduct(name, price, quantity, supplier_id, description);
                System.out.println("product created action");
                request.getRequestDispatcher("create_product.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateServletProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
