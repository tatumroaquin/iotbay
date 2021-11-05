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
import model.dao.DBManagerProduct;

public class ServletProductCreate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session            = request.getSession();
        DBManagerProduct DBManProduct  = (DBManagerProduct) session.getAttribute("DBManProduct");
        String name                    = request.getParameter("name");
        float price                    = Float.parseFloat(request.getParameter("price"));
        int supplier_id                = Integer.parseInt(request.getParameter("supplier"));
        int quantity                   = Integer.parseInt(request.getParameter("quantity"));
        String description             = request.getParameter("description");

        try {
            Product product = DBManProduct.findProduct(supplier_id, name);
            if (product != null) {
                session.setAttribute("error_product_exist", "Product already exists!");
                System.out.println("exist error called");
                request.getRequestDispatcher("create_product.jsp").include(request, response);
            } else {
                DBManProduct.createProduct(name, price, quantity, supplier_id, description);
                System.out.println("product created action");
                request.getRequestDispatcher("create_product.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletProductCreate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
