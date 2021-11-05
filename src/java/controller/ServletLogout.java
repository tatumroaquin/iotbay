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
import model.dao.DBManagerAdmin;
import model.dao.DBManagerStaff;
import model.dao.DBManagerCustomer;
import model.*;
/**
 *
 * @author ormus
 */
public class ServletLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session             = request.getSession();
        DBManagerAdmin DBManAdmin       = (DBManagerAdmin) session.getAttribute("DBManAdmin");
        DBManagerStaff DBManStaff       = (DBManagerStaff) session.getAttribute("DBManStaff");
        DBManagerCustomer DBManCustomer = (DBManagerCustomer) session.getAttribute("DBManCustomer");
        Admin admin                     = (Admin) session.getAttribute("admin");
        Customer customer               = (Customer) session.getAttribute("customer");
        Staff staff                     = (Staff) session.getAttribute("staff");
        if (customer != null)
        {
            try {
                DBManCustomer.updateUALCustomerLogout(customer);
                session.removeAttribute("customer");
                session.setAttribute("firstName", customer.getFirstName());
                session.setAttribute("lastName", customer.getLastName());
                request.getRequestDispatcher("logout.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletLogout.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (staff != null) {
            try {
                DBManStaff.updateUALStaffLogout(staff);
                session.removeAttribute("staff");
                session.setAttribute("firstName", staff.getFirstName());
                session.setAttribute("lastName", staff.getLastName());
                request.getRequestDispatcher("logout.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletLogout.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (admin != null) {
            try {
                DBManAdmin.updateUALAdminLogout(admin);
                session.removeAttribute("admin");
                session.setAttribute("firstName", admin.getFirstName());
                session.setAttribute("lastName", admin.getLastName());
                request.getRequestDispatcher("logout.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ServletLogout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        session.invalidate();
    }
}
