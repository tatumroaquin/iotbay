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
      String query = "SELECT * FROM users ";
      query += "WHERE email=? AND password=?;";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);
      
      ResultSet result = st.executeQuery(query);
      //search the ResultSet for a user using the parameters
      
      Customer customer = new Customer(
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
      
      return customer;
   }

   //Add a user-data into the database   
   public void createCustomer(
      String email, String password, String mobile, 
      String firstName, String lastName,
      String street, String city,  String state, 
      String postCode, String country
   ) throws SQLException {
       
       /*String query = "INSERT INTO Customers(email, password, mobile, firstName, lastName, street, city, state, postCode, country) ";
       query += "VALUES(";
       query += "'"+email+"',";
       query += "'"+password+"',";
       query += "'"+mobile+"',";
       query += "'"+firstName+"',";
       query += "'"+lastName+"',";
       query += "'"+street+"',";
       query += "'"+city+"',";
       query += "'"+state+"',";
       query += ""+postCode+",";
       query += "'"+country+"')";
       /*st.executeUpdate(query);*/
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

       int rows = statement.executeUpdate();
       System.out.println("rows: "+rows);
   }

   //update a user details in the database   
   public void updateCustomer(
      String email, String password, String mobile, 
      String firstName, String lastName,
      String street, String city,  String state, 
      String postCode, String country
   ) throws SQLException {
     String query = "UPDATE Customers SET ";
     query+= "email="+email+",";
     query+= "password="+password+",";
     query+= "mobile="+mobile+",";
     query+= "firstName="+firstName+",";
     query+= "lastName="+lastName+",";
     query+= "street="+street+",";
     query+= "city="+city+",";
     query+= "state="+state+",";
     query+= "postCode="+postCode+",";
     query+= "country="+country+";";
   }

   //delete a user from the database   
   public void deleteUser(String email) throws SQLException{
      //code for delete-operation
      String query = "DELETE FROM Customesr WHERE email="+email+";";
      st.executeUpdate(query);
   }
   
   public ArrayList<Customer> showAll() {
       ArrayList<Customer> customers = new ArrayList<Customer>();
       
       
       return customers;
   }

}
