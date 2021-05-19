package model.dao;

import model.*;
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

   // =================== CUSTOMER CRUD OPERATIONS ===================
   public int findCustomerId(String email, String password) throws SQLException
   {
      String query = "SELECT * FROM Customers ";
      query += "WHERE email=? AND password=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);
      
      ResultSet resultSet = statement.executeQuery();
      int customer_id = 0;
      while(resultSet.next()) {

         String _email = resultSet.getString("email");
         String _pass = resultSet.getString("password");

         if(_email.equals(email) && _pass.equals(password)) {
             customer_id = resultSet.getInt("id");
         }
      }
      
      return customer_id;
   }
   
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
             System.out.println("Customer exist");
            return customer;
         } else {
            System.out.println("Customer does not exist");
         }
         return null;
   }

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
   
   // =================== STAFF CRUD OPERATIONS ===================
   
   public int findStaffId(String email, String password) throws SQLException
   {
      String query = "SELECT * FROM Staff ";
      query += "WHERE email=? AND password=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);
      
      ResultSet resultSet = statement.executeQuery();
      int staff_id = 0;
      while(resultSet.next()) {

         String _email = resultSet.getString("email");
         String _pass = resultSet.getString("password");

         if(_email.equals(email) && _pass.equals(password)) {
             staff_id = resultSet.getInt("id");
         }
      }
      
      return staff_id;
   }
   
   public Staff findStaff(String email, String password) throws SQLException {
      //setup the select sql query string       
      String query = "SELECT * FROM Staff ";
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
            return new Staff(
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
   
   public void createStaff(
      String email, String password, String mobile, 
      String firstName, String lastName,
      String street, String city,  String state, 
      String postCode, String country
   ) throws SQLException {
       String query = "INSERT INTO Staff(email, password, mobile, firstName, lastName, street, city, state, postCode, country) ";
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
   
   public Staff readStaff(
         String email, String password
   ) throws SQLException {
         String query = "SELECT * FROM Staff WHERE email=? AND password=?";

         PreparedStatement statement = this.conn.prepareStatement(query);
         statement.setString(1, email);
         statement.setString(2, password);

         Staff staff = this.findStaff(email, password);

         if (staff != null) {
             System.out.println("Customer exist");
            return staff;
         } else {
            System.out.println("Customer does not exist");
         }
         return null;
   }
   
   public void updateStaff(
      String _email, String _password,
      String email, String password, String mobile, 
      String firstName, String lastName,
      String street, String city, String state, 
      String postCode, String country
   ) throws SQLException {
     String query = "UPDATE Staff SET ";
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
   
   public void deleteStaff(String email, String password) throws SQLException{
      //code for delete-operation
      String query = "DELETE FROM Staff WHERE email=? AND password=?";
      PreparedStatement statement = this.conn.prepareStatement(query);
      statement.setString(1, email);
      statement.setString(2, password);
      int result = statement.executeUpdate();
     System.out.println(result+" rows deleted");
   }
   
   public ArrayList<Staff> fetchStaff() throws SQLException {
       String query = "SELECT * FROM Staff";
       ResultSet result = st.executeQuery(query);

       ArrayList<Staff> staff = new ArrayList();

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
          
          staff.add(new Staff(
                  email, password, mobile, 
                  firstName, lastName, 
                  street, city, state, 
                  postCode, country)
          );
       }

       return staff;
   }

   public boolean checkStaff(String email, String password) throws SQLException {
      String query = "SELECT * FROM Staff WHERE email=? AND password=?";
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

       ArrayList<Admin> admins = new ArrayList();

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
   
   // =================== CITY AND STATE OPERATIONS ===================
   public ArrayList<City> fetchCities() throws SQLException {
       String query = "SELECT * FROM Cities";
       ResultSet result = st.executeQuery(query);

       ArrayList<City> cities = new ArrayList();

       while (result.next()) {
          String name = result.getString("name");
          cities.add(new City(name));
       }

       return cities;
   }
   
   public ArrayList<State> fetchStates() throws SQLException {
       String query = "SELECT * FROM States";
       ResultSet result = st.executeQuery(query);

       ArrayList<State> states = new ArrayList();

       while (result.next()) {
          String acronym = result.getString("acronym");
          String fullName = result.getString("fullName");
          states.add(new State(acronym, fullName));
       }

       return states;
   }
   
   // =================== CUSTOMER USER ACCESS LOGS OPERATIONS ===================
   public ArrayList<UAL> fetchUALCustomer(Customer customer) throws SQLException {
       String query = "SELECT * FROM UALCustomer ";
       query += "WHERE customer_id=?";
       int customer_id = this.findCustomerId(customer.getEmail(), customer.getPassword());
       System.out.println("CUSTOMER ID: "+ customer_id);
       
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setInt(1, customer_id);
       
       ResultSet result = statement.executeQuery();
       ArrayList<UAL> UALs = new ArrayList();

       while (result.next()) {
          int id            = result.getInt("customer_id");
          Date loginDate  = result.getDate("login_date");
          Time loginTime  = result.getTime("login_time");
          Date logoutDate = result.getDate("logout_date");
          Time logoutTime = result.getTime("logout_time");
          
          UALs.add(new UAL(id, loginDate, loginTime, logoutDate, logoutTime));
       }

       return UALs;
   }
   
   public void createUALCustomerLogin(Customer customer) throws SQLException {
       String query = "INSERT INTO UALCustomer(customer_id, login_date, login_time) ";
       query += "VALUES(?, ?, ?)";
       
       java.util.Date dateUtil  = new java.util.Date();
       java.sql.Date dateSQL    = new java.sql.Date(dateUtil.getTime());
       java.sql.Time timeSQL    = new java.sql.Time(dateUtil.getTime());
               
       // find customer id
       int customer_id = this.findCustomerId(customer.getEmail(), customer.getPassword());
       
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setInt(1, customer_id);
       statement.setDate(2, dateSQL);
       statement.setTime(3, timeSQL);

       int result = statement.executeUpdate();
       System.out.println(result+" rows created");
   }
  
   public void updateUALCustomerLogout(Customer customer) throws SQLException {
     String query = "UPDATE UALCustomer SET ";
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
   
   // =================== STAFF USER ACCESS LOGS OPERATIONS ===================
   public ArrayList<UAL> fetchUALStaff(Staff staff) throws SQLException {
       String query = "SELECT * FROM UALStaff ";
       query += "WHERE staff_id=?";
       int staff_id = this.findStaffId(staff.getEmail(), staff.getPassword());
       System.out.println("STAFF ID: "+ staff_id);
       
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setInt(1, staff_id);
       
       ResultSet result = statement.executeQuery();
       ArrayList<UAL> UALs = new ArrayList();

       while (result.next()) {
          int id            = result.getInt("staff_id");
          Date loginDate  = result.getDate("login_date");
          Time loginTime  = result.getTime("login_time");
          Date logoutDate = result.getDate("logout_date");
          Time logoutTime = result.getTime("logout_time");
          
          UALs.add(new UAL(id, loginDate, loginTime, logoutDate, logoutTime));
       }

       return UALs;
   }
   
   public void createUALStaffLogin(Staff staff) throws SQLException {
       String query = "INSERT INTO UALStaff(staff_id, login_date, login_time) ";
       query += "VALUES(?, ?, ?)";
       
       java.util.Date dateUtil  = new java.util.Date();
       java.sql.Date dateSQL    = new java.sql.Date(dateUtil.getTime());
       java.sql.Time timeSQL    = new java.sql.Time(dateUtil.getTime());
               
       // find customer id
       int staff_id = this.findStaffId(staff.getEmail(), staff.getPassword());
       
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setInt(1, staff_id);
       statement.setDate(2, dateSQL);
       statement.setTime(3, timeSQL);

       int result = statement.executeUpdate();
       System.out.println(result+" rows created");
   }
  
   public void updateUALStaffLogout(Staff staff) throws SQLException {
     String query = "UPDATE UALStaff SET ";
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
   
   // =================== ADMIN USER ACCESS LOGS OPERATIONS ===================
   public ArrayList<UAL> fetchUALAdmin(Admin admin) throws SQLException {
       String query = "SELECT * FROM UALAdmin ";
       query += "WHERE admin_id=?";
       int admin_id = this.findAdminId(admin.getEmail(), admin.getPassword());
       System.out.println("ADMIN ID: "+ admin_id);
       
       PreparedStatement statement = this.conn.prepareStatement(query);
       statement.setInt(1, admin_id);
       
       ResultSet result = statement.executeQuery();
       ArrayList<UAL> UALs = new ArrayList();

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

       ArrayList<Supplier> suppliers = new ArrayList();

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
             supplier_id  = resultSet.getInt("id");
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

       ArrayList<Product> products = new ArrayList();

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
}
