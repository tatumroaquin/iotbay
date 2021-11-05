package model.dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManagerProduct {

   private final Connection conn;
   private final Statement st;

   public DBManagerProduct(Connection conn) throws SQLException {
      this.conn = conn;
      this.st = conn.createStatement();
   }

   // =================== PRODUCT CRUD OPERATIONS ===================
   public int findProductId(int supplier_id, String name) throws SQLException
   {
      String query = "SELECT * FROM Products ";
      query += "WHERE supplier_id=? AND name=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setInt(1, supplier_id);
      statement.setString(2, name);
      
      ResultSet resultSet = statement.executeQuery();
      int product_id = 0;
      while(resultSet.next()) {

         int _supplier_id = resultSet.getInt("supplier_id");
         String _name     = resultSet.getString("name");

         if(_supplier_id == supplier_id && _name.equals(name)) {
             product_id  = resultSet.getInt("id");
         }
      }
      
      return product_id;
   }
   
   public Product findProduct(int supplier_id, String name) throws SQLException {
      //setup the select sql query string       
      String query = "SELECT * FROM Products ";
      query += "WHERE name=? AND supplier_id=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, name);
      statement.setInt(2, supplier_id);
      
      ResultSet result = statement.executeQuery();
      
      //search the ResultSet for a user using the parameters
      while(result.next()) {
         String _name     = result.getString("name");
         int _supplier_id = result.getInt("supplier_id");

         if(_name.equals(name) && _supplier_id == supplier_id) {
            return new Product(
                    result.getString("name"),
                    result.getFloat("price"),
                    result.getInt("quantity"),
                    result.getInt("supplier_id"),
                    result.getString("description")
            );
         }
      }
      
      return null;
   }
   
   public ArrayList<Product> fetchProducts() throws SQLException {
       String query = "SELECT * FROM Products";
       ResultSet result = st.executeQuery(query);

       ArrayList<Product> products = new ArrayList<>();

       while (result.next()) {
          String name        = result.getString("name");
          float price        = result.getFloat("price");
          int quantity       = result.getInt("quantity");
          int supplier_id    = result.getInt("supplier_id");
          String description = result.getString("description");
          products.add(new Product(name, price, quantity, supplier_id, description));
       }

       return products;
   }
   
   public void createProduct(
           String name, float price, int quantity,
           int supplier, String description
   ) throws SQLException {
       String query = "INSERT INTO Products(supplier_id, name, price, description, quantity) ";
       query += "VALUES(?,?,?,?,?)";
       
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setInt(1, supplier);
       statement.setString(2, name);
       statement.setFloat(3, price);
       statement.setString(4, description);
       statement.setInt(5, quantity);
       
       int result = statement.executeUpdate();
       System.out.println(result+" rows created");
   }
   
   public void deleteProduct(int supplier_id, String name) throws SQLException{
      //code for delete-operation
      String query = "DELETE FROM Products WHERE supplier_id=? AND name=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setInt(1, supplier_id);
      statement.setString(2, name);
      int result = statement.executeUpdate();
      System.out.println(result+" rows deleted");
   }

   public void updateProduct(
          String _name, int _supplier, 
          int supplier, String name, float price, String desc, int quantity 
      ) throws SQLException {
        String query = "UPDATE Products SET ";
        query += "supplier_id=?, name=?, price=?, description=?, quantity=? ";
        query += "WHERE email=? AND password=?";
        
        PreparedStatement statement = this.conn.prepareStatement(query);
        statement.setInt(1, supplier);
        statement.setString(2, name);
        statement.setFloat(3, price);
        statement.setString(4, desc);
        statement.setInt(5, quantity);

        statement.setString(6, _name);
        statement.setInt(7, _supplier);
        int result = statement.executeUpdate();
        System.out.println(result+" rows updated");
      }
}
