package model.dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManagerCity {

   private final Connection conn;
   private final Statement st;

   public DBManagerCity(Connection conn) throws SQLException {
      this.conn = conn;
      this.st = conn.createStatement();
   }
   
   // =================== CITY AND STATE OPERATIONS ===================
   public ArrayList<City> fetchCities() throws SQLException {
       String query = "SELECT * FROM Cities";
       ResultSet result = st.executeQuery(query);

       ArrayList<City> cities = new ArrayList<>();

       while (result.next()) {
          String name = result.getString("name");
          cities.add(new City(name));
       }

       return cities;
   }
}
