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
import model.dao.DBManagerStaff;
public class ServletStaffDelete extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        DBManagerStaff DBManStaff   = (DBManagerStaff) session.getAttribute("DBManStaff");
        Staff staff   = (Staff) session.getAttribute("staff");
        
        String _email       = staff.getEmail();
        String _password    = staff.getPassword();
        
        validator.clear(session);
        try {
            DBManStaff.deleteStaff(_email, _password);
            request.getRequestDispatcher("LogoutServlet").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletStaffDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
