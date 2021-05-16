package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.DBManager;
import model.*;

public class LoginServletStaff extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

      HttpSession session = request.getSession();
      Validator validator = new Validator();

      String email = request.getParameter("email");
      String password = request.getParameter("password");

      DBManager manager = (DBManager) session.getAttribute("manager");
      Staff staff;

      validator.clear(session);

      if (!validator.validateEmail(email)) {
         session.setAttribute("error_staff_email", "Error: Email format invalid");
         request.getRequestDispatcher("login_staff.jsp").include(request, response);
      } else if (!validator.validatePassword(password)) {
         session.setAttribute("error_staff_pass", "Error: Password format invalid");
         request.getRequestDispatcher("login_staff.jsp").include(request, response);
      } else {
         try {
            staff = manager.findStaff(email, password);
            if (staff != null) {
               manager.createUALStaffLogin(staff);
               session.setAttribute("staff", staff);
               request.getRequestDispatcher("login_staff.jsp").include(request, response);
            } else {
               session.setAttribute("error_staff_not_exist", "Staff does not exist");
               request.getRequestDispatcher("login_staff.jsp").include(request, response);
            }
         } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Staff does not exist" : "Welcome");
         }
      }
   }
}
