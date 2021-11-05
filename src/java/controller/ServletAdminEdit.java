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
import model.dao.DBManagerAdmin;
public class ServletAdminEdit extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session         = request.getSession();
        Validator validator         = new Validator();
        DBManagerAdmin DBManAdmin   = (DBManagerAdmin) session.getAttribute("DBManAdmin");
        Admin admin                 = (Admin) session.getAttribute("admin");
        String _email               = admin.getEmail();
        String _password            = admin.getPassword();
        String email                = request.getParameter("email");
        String password             = request.getParameter("password");
        String mobile               = request.getParameter("mobile");
        String firstName            = request.getParameter("fname");
        String lastName             = request.getParameter("lname");
        String street               = request.getParameter("street");
        String city                 = request.getParameter("city");
        String state                = request.getParameter("state");
        String postCode             = request.getParameter("postcode");
        String country              = request.getParameter("country");
        
        validator.clear(session);
        
        if (!validator.validateEmail(email)) {
            session.setAttribute("error_admin_email", "Error: Email format is incorrect");
            System.out.println("email error called");
            request.getRequestDispatcher("edit_admin.jsp").include(request, response);
        } else if (!validator.validateName(firstName) && !validator.validateName(lastName)) {
            session.setAttribute("error_admin_name", "Error: Name format is incorrect");
            System.out.println("name error called");
            request.getRequestDispatcher("edit_admin.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("error_admin_password", "Error: Email format is incorrect");
            System.out.println("password error called");
            request.getRequestDispatcher("edit_admin.jsp").include(request, response);
        } else {
            try {
                DBManAdmin.updateAdmin(_email, _password, email, password, mobile, firstName, lastName, street, city, state, postCode, country);
                admin = new Admin(email, password, mobile, firstName, lastName, street, city, state, postCode, country);
                session.setAttribute("admin", admin);
                request.getRequestDispatcher("edit_admin.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletAdminEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
