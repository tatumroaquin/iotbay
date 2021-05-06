package model.dao;

import model.Customer;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManager {

   private Connection conn;
   private Statement st;

   public DBManager(Connection conn) throws SQLException {
      this.conn = conn;
      this.st = conn.createStatement();
   }

   //Find user by email and password in the database   
   public Customer findCustomer(String email, String password) throws SQLException {
      //setup the select sql query string       
      String query = "SELECT * FROM Customers ";
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
            return new Customer(
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

   //Add a user-data into the database   
   public void createCustomer(
      String email, String password, String mobile, 
      String firstName, String lastName,
      String street, String city,  String state, 
      String postCode, String country
   ) throws SQLException {
       String query = "INSERT INTO Customers(email, password, mobile, firstName, lastName, street, city, state, postCode, country) ";
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

   public Customer readCustomer(
         String email, String password
   ) throws SQLException {
         String query = "SELECT * FROM Customers WHERE email=? AND password=?";

         PreparedStatement statement = this.conn.prepareStatement(query);
         statement.setString(1, email);
         statement.setString(2, password);

         Customer customer = this.findCustomer(email, password);

         if (customer != null) {
             System.out.println("Custoemr exist");
            return customer;
         } else {
            System.out.println("Customer does not exist");
         }
         return null;
   }

   //update customer details in the database   
   public void updateCustomer(
      String _email, String _password,
      String email, String password, String mobile, 
      String firstName, String lastName,
      String street, String city, String state, 
      String postCode, String country
   ) throws SQLException {
     String query = "UPDATE Customers SET ";
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

   //delete a user from the database   
   public void deleteCustomer(String email, String password) throws SQLException{
      //code for delete-operation
      String query = "DELETE FROM Customers WHERE email=? AND password=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);
      int result = statement.executeUpdate();
     System.out.println(result+" rows deleted");
   }
   
   public ArrayList<Customer> fetchCustomers() throws SQLException {
       String query = "SELECT * FROM Customers";
       ResultSet result = st.executeQuery(query);

       ArrayList<Customer> customers = new ArrayList();

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
          
          customers.add(new Customer(
                  email, password, mobile, 
                  firstName, lastName, 
                  street, city, state, 
                  postCode, country)
          );
       }

       return customers;
   }

   public boolean checkCustomer(String email, String password) throws SQLException {
      String query = "SELECT * FROM Customers WHERE email=? AND password=?";
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
}
