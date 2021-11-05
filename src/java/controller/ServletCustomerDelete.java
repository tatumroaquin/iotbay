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
import model.dao.DBManagerCustomer;
public class ServletCustomerDelete extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        DBManagerCustomer DBManCustomer   = (DBManagerCustomer) session.getAttribute("DBManCustomer");
        Customer customer   = (Customer) session.getAttribute("customer");
        
        String _email       = customer.getEmail();
        String _password    = customer.getPassword();
        
        validator.clear(session);
        try {
            DBManCustomer.deleteCustomer(_email, _password);
            request.getRequestDispatcher("LogoutServlet").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletCustomerDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
