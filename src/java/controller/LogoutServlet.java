/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.DBManager;
import model.*;
/**
 *
 * @author ormus
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        
        Admin admin       = (Admin) session.getAttribute("admin");
        Customer customer = (Customer) session.getAttribute("customer");
        Staff staff       = (Staff) session.getAttribute("staff");
        if (customer != null)
        {
            try {
                manager.updateUALCustomerLogout(customer);
                request.getRequestDispatcher("logout.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (staff != null) {
            try {
                manager.updateUALStaffLogout(staff);
                request.getRequestDispatcher("logout.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (admin != null) {
            try {
                manager.updateUALAdminLogout(admin);
                request.getRequestDispatcher("logout.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
