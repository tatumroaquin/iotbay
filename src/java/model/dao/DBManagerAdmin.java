package model.dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManagerAdmin {

   private final Connection conn;
   private final Statement st;

   public DBManagerAdmin(Connection conn) throws SQLException {
      this.conn = conn;
      this.st = conn.createStatement();
   }
   
   // =================== ADMIN CRUD OPERATIONS ===================
   public int findAdminId(String email, String password) throws SQLException
   {
      String query = "SELECT * FROM Admin ";
      query += "WHERE email=? AND password=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);
      
      ResultSet resultSet = statement.executeQuery();
      int admin_id = 0;
      while(resultSet.next()) {

         String _email = resultSet.getString("email");
         String _pass = resultSet.getString("password");

         if(_email.equals(email) && _pass.equals(password)) {
             admin_id = resultSet.getInt("id");
         }
      }
      
      return admin_id;
   }
   
   public Admin findAdmin(String email, String password) throws SQLException {
      //setup the select sql query string       
      String query = "SELECT * FROM Admin ";
      query += "WHERE email=? AND password=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);
      
      ResultSet result = statement.executeQuery();
      
      //search the ResultSet for a user using the parameters
      while(result.next()) {

         String _email = result.getString("email");
         String _pass = result.getString("password");

         if(_email.equals(email) && _pass.equals(password)) {
            return new Admin(
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("mobile"),
                    result.getString("firstName"),
                    result.getString("lastName"),
                    result.getString("street"),
                    result.getString("city"),
                    result.getString("state"),
                    result.getString("postCode"),
                    result.getString("country")
            );
         }
      }
      
      return null;
   }
   
   public void createAdmin(
      String email, String password, String mobile, 
      String firstName, String lastName,
      String street, String city,  String state, 
      String postCode, String country
   ) throws SQLException {
       String query = "INSERT INTO Admin(email, password, mobile, firstName, lastName, street, city, state, postCode, country) ";
       query += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setString(1, email);
       statement.setString(2, password);
       statement.setString(3, mobile);
       statement.setString(4, firstName);
       statement.setString(5, lastName);
       statement.setString(6, street);
       statement.setString(7, city);
       statement.setString(8, state);
       statement.setString(9, postCode);
       statement.setString(10, country);

       int result = statement.executeUpdate();
       System.out.println(result+" rows created");
   }
   
   public Admin readAdmin(
         String email, String password
   ) throws SQLException {
         String query = "SELECT * FROM Admin WHERE email=? AND password=?";

         PreparedStatement statement = this.conn.prepareStatement(query);
         statement.setString(1, email);
         statement.setString(2, password);

         Admin admin = this.findAdmin(email, password);

         if (admin != null) {
             System.out.println("Customer exist");
            return admin;
         } else {
            System.out.println("Customer does not exist");
         }
         return null;
   }
   
   public void updateAdmin(
      String _email, String _password,
      String email, String password, String mobile, 
      String firstName, String lastName,
      String street, String city, String state, 
      String postCode, String country
   ) throws SQLException {
     String query = "UPDATE Admin SET ";
     query += "email=?, password=?, mobile=?, firstName=?, lastName=?, ";
     query += "street=?, city=?, state=?, postCode=?, country=? ";
     query += "WHERE email=? AND password=?";
     
     PreparedStatement statement = this.conn.prepareStatement(query);
     statement.setString(1, email);
     statement.setString(2, password);
     statement.setString(3, mobile);
     statement.setString(4, firstName);
     statement.setString(5, lastName);
     statement.setString(6, street);
     statement.setString(7, city);
     statement.setString(8, state);
     statement.setString(9, postCode);
     statement.setString(10, country);
     statement.setString(11, _email);
     statement.setString(12, _password);
     int result = statement.executeUpdate();
     System.out.println(result+" rows updated");
   }
   
   public void deleteAdmin(String email, String password) throws SQLException{
      //code for delete-operation
      String query = "DELETE FROM Admin WHERE email=? AND password=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);
      int result = statement.executeUpdate();
     System.out.println(result+" rows deleted");
   }
   
   public ArrayList<Admin> fetchAdmins() throws SQLException {
       String query = "SELECT * FROM Admin";
       ResultSet result = st.executeQuery(query);

       ArrayList<Admin> admins = new ArrayList<>();

       while (result.next()) {
          String email = result.getString("email");
          String password = result.getString("password");
          String mobile = result.getString("mobile");
          String firstName = result.getString("firstName");
          String lastName = result.getString("lastName");
          String street = result.getString("street");
          String city = result.getString("city");
          String state = result.getString("state");
          String postCode = result.getString("postCode");
          String country = result.getString("country");
          
          admins.add(new Admin(
                  email, password, mobile, 
                  firstName, lastName, 
                  street, city, state, 
                  postCode, country)
          );
       }

       return admins;
   }
   
   public boolean checkAdmin(String email, String password) throws SQLException {
      String query = "SELECT * FROM Admin WHERE email=? AND password=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);

      ResultSet result = statement.executeQuery();

      while (result.next()) {
         String _email = result.getString("email");
         String _pass  = result.getString("password");
         return _email.equals(email) && _pass.equals(password);
      }

      return false;
   }
   
   // =================== ADMIN USER ACCESS LOGS OPERATIONS ===================
   public ArrayList<UAL> fetchUALAdmin(Admin admin) throws SQLException {
       String query = "SELECT * FROM UALAdmin ";
       query += "WHERE admin_id=?";
       int admin_id = this.findAdminId(admin.getEmail(), admin.getPassword());
       System.out.println("ADMIN ID: "+ admin_id);
       
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setInt(1, admin_id);
       
       ResultSet result = statement.executeQuery();
       ArrayList<UAL> UALs = new ArrayList<>();

       while (result.next()) {
          int id            = result.getInt("admin_id");
          Date loginDate  = result.getDate("login_date");
          Time loginTime  = result.getTime("login_time");
          Date logoutDate = result.getDate("logout_date");
          Time logoutTime = result.getTime("logout_time");
          
          UALs.add(new UAL(id, loginDate, loginTime, logoutDate, logoutTime));
       }

       return UALs;
   }
   
   public void createUALAdminLogin(Admin admin) throws SQLException {
       String query = "INSERT INTO UALAdmin(admin_id, login_date, login_time) ";
       query += "VALUES(?, ?, ?)";
       
       java.util.Date dateUtil  = new java.util.Date();
       java.sql.Date dateSQL    = new java.sql.Date(dateUtil.getTime());
       java.sql.Time timeSQL    = new java.sql.Time(dateUtil.getTime());
               
       // find customer id
       int admin_id = this.findAdminId(admin.getEmail(), admin.getPassword());
       
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setInt(1, admin_id);
       statement.setDate(2, dateSQL);
       statement.setTime(3, timeSQL);

       int result = statement.executeUpdate();
       System.out.println(result+" rows created");
   }
  
   public void updateUALAdminLogout(Admin admin) throws SQLException {
     String query = "UPDATE UALAdmin SET ";
     query += "logout_date=?, logout_time=? ";
     query += "WHERE logout_date IS NULL AND logout_time IS NULL";
     
     java.util.Date dateUtil  = new java.util.Date();
     java.sql.Date dateSQL    = new java.sql.Date(dateUtil.getTime());
     java.sql.Time timeSQL    = new java.sql.Time(dateUtil.getTime());
     
     PreparedStatement statement = this.conn.prepareStatement(query);
     statement.setDate(1, dateSQL);
     statement.setTime(2, timeSQL);
     
     int result = statement.executeUpdate();
     System.out.println(result+" rows updated");
   }
}
