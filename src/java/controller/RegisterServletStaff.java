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
public class RegisterServletStaff extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        DBManager manager   = (DBManager) session.getAttribute("manager");
        
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
            session.setAttribute("error_staff_email", "Error: Email format is incorrect");
            System.out.println("email error called");
            request.getRequestDispatcher("register_staff.jsp").include(request, response);
        } else if (!validator.validateName(firstName) && !validator.validateName(lastName)) {
            session.setAttribute("error_staff_name", "Error: Name format is incorrect");
            System.out.println("name error called");
            request.getRequestDispatcher("register_staff.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("error_staff_password", "Error: Email format is incorrect");
            System.out.println("password error called");
            request.getRequestDispatcher("register_staff.jsp").include(request, response);
        } else {
            try {
                Staff staff = manager.findStaff(email, password);
                if(staff != null) {
                    session.setAttribute("error_staff_exist", "staff already exists in the database!");
                    System.out.println("exist error called");
                    request.getRequestDispatcher("register_staff.jsp").include(request, response);
                } else {
                    manager.createStaff(email, password, mobile, firstName, lastName, street, city, state, postCode, country);
                    staff = new Staff(email, password, mobile, firstName, lastName, street, city, state, postCode, country);
                    session.setAttribute("staff", staff);
                    System.out.println("staff created action");
                    request.getRequestDispatcher("register_staff.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServletStaff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
