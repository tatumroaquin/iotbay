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
public class ServletCustomerRegister extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        DBManagerCustomer DBManCustomer   = (DBManagerCustomer) session.getAttribute("DBManCustomer");
        
        String email        = request.getParameter("email");
        String password     = request.getParameter("password");
        String mobile       = request.getParameter("mobile");
        String firstName    = request.getParameter("fname");
        String lastName     = request.getParameter("lname");
        String street       = request.getParameter("street");
        String city         = request.getParameter("city");
        String state        = request.getParameter("state");
        String postCode     = request.getParameter("postcode");
        String country      = request.getParameter("country");
        
        validator.clear(session);
        
        if (!validator.validateEmail(email)) {
            session.setAttribute("error_customer_email", "Error: Email format is incorrect");
            System.out.println("email error called");
            request.getRequestDispatcher("register_customer.jsp").include(request, response);
        } else if (!validator.validateName(firstName) && !validator.validateName(lastName)) {
            session.setAttribute("error_customer_name", "Error: Name format is incorrect");
            System.out.println("name error called");
            request.getRequestDispatcher("register_customer.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("error_customer_password", "Error: Email format is incorrect");
            System.out.println("password error called");
            request.getRequestDispatcher("register_customer.jsp").include(request, response);
        } else {
            try {
                Customer customer = DBManCustomer.findCustomer(email, password);
                if(customer != null) {
                    session.setAttribute("error_customer_exist", "Customer already exists in the database!");
                    System.out.println("exist error called");
                    request.getRequestDispatcher("register_customer.jsp").include(request, response);
                } else {
                    DBManCustomer.createCustomer(email, password, mobile, firstName, lastName, street, city, state, postCode, country);
                    customer = new Customer(email, password, mobile, firstName, lastName, street, city, state, postCode, country);
                    session.setAttribute("customer", customer);
                    System.out.println("customer created action");
                    request.getRequestDispatcher("register_customer.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletCustomerRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
