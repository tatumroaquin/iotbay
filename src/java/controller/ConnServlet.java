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

public class ConnServlet extends HttpServlet {
   private DBConnector db;
   private DBManager manager;
   private Connection conn;

   @Override // create isntance of DBConnector for the deployment session
   public void init() {
      try {
         db = new DBConnector();
      } catch (ClassNotFoundException | SQLException ex) {
         Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   @Override // add the DBManager instance to the session
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      conn = db.openConnection();
      
      PrintWriter out = response.getWriter();

      try {
         manager = new DBManager(conn);
      } catch (SQLException ex) {
         Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
      }

      session.setAttribute("manager", manager);
   }

   @Override
   public void destroy() {
      try {
         db.closeConnection();
      } catch (SQLException ex) {
         Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
