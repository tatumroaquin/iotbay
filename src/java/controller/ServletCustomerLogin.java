package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.DBManagerCustomer;
import model.*;

public class ServletCustomerLogin extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

      HttpSession session = request.getSession();
      Validator validator = new Validator();

      String email = request.getParameter("email");
      String password = request.getParameter("password");

      DBManagerCustomer DBManCustomer = (DBManagerCustomer) session.getAttribute("DBManCustomer");
      Customer customer;

      validator.clear(session);

      if (!validator.validateEmail(email)) {
         session.setAttribute("error_customer_email", "Error: Email format invalid");
         request.getRequestDispatcher("login_customer.jsp").include(request, response);
      } else if (!validator.validatePassword(password)) {
         session.setAttribute("error_customer_pass", "Error: Password format invalid");
         request.getRequestDispatcher("login_customer.jsp").include(request, response);
      } else {
         try {
            customer = DBManCustomer.findCustomer(email, password);
            if (customer != null) {
               DBManCustomer.createUALCustomerLogin(customer);
               session.setAttribute("customer", customer);
               request.getRequestDispatcher("login_customer.jsp").include(request, response);
            } else {
               session.setAttribute("error_customer_not_exist", "Customer does not exist");
               request.getRequestDispatcher("login_customer.jsp").include(request, response);
            }
         } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Customer does not exist" : "Welcome");
         }
      }
   }
}
