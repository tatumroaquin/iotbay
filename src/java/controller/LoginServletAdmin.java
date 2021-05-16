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

public class LoginServletAdmin extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

      HttpSession session = request.getSession();
      Validator validator = new Validator();

      String email = request.getParameter("email");
      String password = request.getParameter("password");

      DBManager manager = (DBManager) session.getAttribute("manager");
      Admin admin;

      validator.clear(session);

      if (!validator.validateEmail(email)) {
         session.setAttribute("error_admin_email", "Error: Email format invalid");
         request.getRequestDispatcher("login_admin.jsp").include(request, response);
      } else if (!validator.validatePassword(password)) {
         session.setAttribute("error_admin_pass", "Error: Password format invalid");
         request.getRequestDispatcher("login_admin.jsp").include(request, response);
      } else {
         try {
            admin = manager.findAdmin(email, password);
            if (admin != null) {
               manager.createUALAdminLogin(admin);
               session.setAttribute("admin", admin);
               request.getRequestDispatcher("login_admin.jsp").include(request, response);
            } else {
               session.setAttribute("error_staff_not_exist", "Staff does not exist");
               request.getRequestDispatcher("login_admin.jsp").include(request, response);
            }
         } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Staff does not exist" : "Welcome");
         }
      }
   }
}
