package model.dao;

import model.*;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManagerState {

   private final Connection conn;
   private final Statement st;

   public DBManagerState(Connection conn) throws SQLException {
      this.conn = conn;
      this.st = conn.createStatement();
   }

   public ArrayList<State> fetchStates() throws SQLException {
       String query = "SELECT * FROM States";
       ResultSet result = st.executeQuery(query);

       ArrayList<State> states = new ArrayList<>();

       while (result.next()) {
          String acronym = result.getString("acronym");
          String fullName = result.getString("fullName");
          states.add(new State(acronym, fullName));
       }

       return states;
   }
}
