package controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

public class Validator implements Serializable {
   private final String emailPattern      = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";
   //private final String namePattern       = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";
   private final String namePattern       = "([A-Z][a-z]+)";
   private final String passwordPattern   = "[a-z0-9]{4,}";

   public Validator(){}

   public boolean validate(String pattern, String input) {
      Pattern regEx = Pattern.compile(pattern);
      Matcher match = regEx.matcher(input);

      return match.matches();
   }

   public boolean checkEmpty(String email, String password) {
      return  email.isEmpty() || password.isEmpty();
   }

   public boolean validateEmail(String email) {
      return validate(emailPattern,email);
   }

   public boolean validateName(String name) {
      return validate(namePattern,name);
   }

   public boolean validatePassword(String password) {
      return validate(passwordPattern,password);
   }
   
   public void clearAdmin(HttpSession session) {
      session.removeAttribute("error_admin_email");
      session.removeAttribute("error_admin_pass");
      session.removeAttribute("error_admin_name");
      session.removeAttribute("error_admin_exist");
      session.removeAttribute("error_admin_not_exist");
   }
   
   public void clearCustomer(HttpSession session) {
      session.removeAttribute("error_customer_email");
      session.removeAttribute("error_customer_pass");
      session.removeAttribute("error_customer_name");
      session.removeAttribute("error_customer_exist");
      session.removeAttribute("error_customer_not_exist");
   }
   
   public void clearStaff(HttpSession session) {
      session.removeAttribute("error_staff_email");
      session.removeAttribute("error_staff_pass");
      session.removeAttribute("error_staff_name");
      session.removeAttribute("error_staff_exist");
      session.removeAttribute("error_staff_not_exist");
   }
   
   public void clear(HttpSession session) {
       this.clearAdmin(session);
       this.clearCustomer(session);
       this.clearStaff(session);
   }
}
