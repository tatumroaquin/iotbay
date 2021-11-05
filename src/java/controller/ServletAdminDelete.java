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
public class ServletAdminDelete extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session         = request.getSession();
        Validator validator         = new Validator();
        DBManagerAdmin DBManAdmin   = (DBManagerAdmin) session.getAttribute("DBManAdmin");
        Admin admin                 = (Admin) session.getAttribute("admin");
        
        String _email               = admin.getEmail();
        String _password            = admin.getPassword();
        
        validator.clear(session);
        try {
            DBManAdmin.deleteAdmin(_email, _password);
            request.getRequestDispatcher("LogoutServlet").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletAdminDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
