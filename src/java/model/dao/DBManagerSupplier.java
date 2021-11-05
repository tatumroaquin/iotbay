package model.dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManagerSupplier {

   private Connection conn;
   private Statement st;

   public DBManagerSupplier(Connection conn) throws SQLException {
      this.conn = conn;
      this.st = conn.createStatement();
   }

   // =================== SUPPLIER CRUD OPERATIONS ===================
   public int findSupplierId(String companyName, String email) throws SQLException
   {
      String query = "SELECT * FROM Suppliers ";
      query += "WHERE companyName=? AND email=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, companyName);
      statement.setString(2, email);
      
      ResultSet resultSet = statement.executeQuery();
      int supplier_id = 0;
      while(resultSet.next()) {

         String _companyName = resultSet.getString("companyName");
         String _email       = resultSet.getString("email");

         if(_email.equals(email) && _companyName.equals(companyName)) {
             supplier_id = resultSet.getInt("id");
         }
      }
      
      return supplier_id;
   }
   
   public Supplier findSupplier(int id) throws SQLException {
      //setup the select sql query string       
      String query = "SELECT * FROM Admin ";
      query += "WHERE id=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setInt(1, id);
      
      ResultSet result = statement.executeQuery();
      
      //search the ResultSet for a user using the parameters
      while(result.next()) {
            return new Supplier(
                    result.getString("companyName"),
                    result.getString("email"),
                    result.getString("firstName"),
                    result.getString("lastName"),
                    result.getString("mobile")
            );
      }
      
      return null;
   }
   
   public ArrayList<Supplier> fetchSuppliers() throws SQLException {
       String query = "SELECT * FROM Suppliers";
       ResultSet result = st.executeQuery(query);

       ArrayList<Supplier> suppliers = new ArrayList<>();

       while (result.next()) {
          String companyName = result.getString("companyName");
          String email       = result.getString("email");
          String firstName   = result.getString("firstName");
          String lastName    = result.getString("lastName");
          String mobile      = result.getString("mobile");
          suppliers.add(new Supplier(companyName, email, firstName, lastName, mobile));
       }

       return suppliers;
   }
}
