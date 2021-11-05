package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.*;

public class ServletDBConnect extends HttpServlet {
   private DBConnector db;
   private DBManagerCustomer DBManCustomer;
   private DBManagerStaff DBManStaff;
   private DBManagerAdmin DBManAdmin;
   private DBManagerProduct DBManProduct;
   private DBManagerSupplier DBManSupplier;
   private DBManagerCity DBManCity;
   private DBManagerState DBManState;
   private Connection conn;

   @Override // create isntance of DBConnector for the deployment session
   public void init() {
      try {
         db = new DBConnector();
      } catch (ClassNotFoundException | SQLException ex) {
         Logger.getLogger(ServletDBConnect.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   @Override // add the DBManager instance to the session
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      conn = db.openConnection();

      try {
         DBManCustomer = new DBManagerCustomer(conn);
         DBManStaff = new DBManagerStaff(conn);
         DBManAdmin = new DBManagerAdmin(conn);
         DBManProduct = new DBManagerProduct(conn);
         DBManCity = new DBManagerCity(conn);
         DBManState = new DBManagerState(conn);
         DBManSupplier = new DBManagerSupplier(conn);
      } catch (SQLException ex) {
         Logger.getLogger(ServletDBConnect.class.getName()).log(Level.SEVERE, null, ex);
      }

      session.setAttribute("DBManCustomer", DBManCustomer);
      session.setAttribute("DBManStaff", DBManStaff);
      session.setAttribute("DBManAdmin", DBManAdmin);
      session.setAttribute("DBManProduct", DBManProduct);
      session.setAttribute("DBManSupplier", DBManSupplier);
      session.setAttribute("DBManCity", DBManCity);
      session.setAttribute("DBManState", DBManState);
   }

   @Override
   public void destroy() {
      try {
         db.closeConnection();
      } catch (SQLException ex) {
         Logger.getLogger(ServletDBConnect.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
