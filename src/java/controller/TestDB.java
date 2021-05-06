package controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import java.util.ArrayList;
import model.*;
import model.dao.*;

public class TestDB {
    
   private DBConnector connector;
   private Connection conn;
   private DBManager db;
    
   private static Scanner in = new Scanner(System.in);
   
   public TestDB() {
       try {
           this.connector = new DBConnector();
           this.conn = connector.openConnection();
           this.db = new DBManager(conn);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

   public static void main(String[] args) throws SQLException {
      (new TestDB()).menu();
   }
   
   private char readChoice() {
       System.out.print("Operation CRUDS or * to exit: ");
       return in.nextLine().charAt(0);
   }
   
   private void menu() throws SQLException {
       char c;
       
       while((c = readChoice()) != '*') {
           switch(c) {
               case 'c':
                   testCreateCustomer();
                   break;
               case 'r':
                   testReadCustomer();
                   break;
               case 'u':
                   testUpdateCustomer();
                   break;
               case 'd':
                   testDeleteCustomer();
                   break;
               case 's':
                   showAll();
                   break;
               default:
                   System.out.println("Unknown Command");
                   break;
           }
       }
   }
   
   private void testCreateCustomer() {
       try {
           System.out.print("User email: ");
           String email = in.nextLine();

           System.out.print("User password: ");
           String password = in.nextLine();

           System.out.print("User mobile: ");
           String mobile = in.nextLine();

           System.out.print("First name: ");
           String firstName = in.nextLine();

           System.out.print("Last name: ");
           String lastName = in.nextLine();

           System.out.print("User street: ");
           String street = in.nextLine();

           System.out.print("User city: ");
           String city = in.nextLine();

           System.out.print("User state: ");
           String state = in.nextLine();

           System.out.print("User postcode: ");
           String postCode = in.nextLine();

           System.out.print("User country: ");
           String country = in.nextLine();

           db.createCustomer(
                 email, password, mobile,
                 firstName, lastName,
                 street, city, state,
                 postCode, country
           );
           System.out.println("User is added to the database.");

        } catch (SQLException ex) {
           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   private void testReadCustomer() throws SQLException {
      try {
           System.out.print("User email: ");
           String email = in.nextLine();

           System.out.print("User password: ");
           String password = in.nextLine();
           
           Customer customer = db.findCustomer(email, password);
           if(customer != null) {
               System.out.println(customer.getFirstName()+" exist.");
           } else {
               System.out.println("Customer does not exist");
           }
      } catch (SQLException ex) {
           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   private void testUpdateCustomer() {
           System.out.print("User email: ");
           String _email = in.nextLine();

           System.out.print("User password: ");
           String _password = in.nextLine();

      try {
           if (db.checkCustomer(_email, _password)) {
              System.out.println("---ENTER NEW DETAILS---");
              System.out.print("User email: ");
              String email = in.nextLine();

              System.out.print("User password: ");
              String password = in.nextLine();

              System.out.print("User mobile: ");
              String mobile = in.nextLine();

              System.out.print("First name: ");
              String firstName = in.nextLine();

              System.out.print("Last name: ");
              String lastName = in.nextLine();

              System.out.print("User street: ");
              String street = in.nextLine();

              System.out.print("User city: ");
              String city = in.nextLine();

              System.out.print("User state: ");
              String state = in.nextLine();

              System.out.print("User postcode: ");
              String postCode = in.nextLine();

              System.out.print("User country: ");
              String country = in.nextLine();
              db.updateCustomer(_email, _password, email, password, mobile, firstName, lastName, street, city, state, postCode, country);
           }
      } catch (SQLException ex) {
           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

   private void testDeleteCustomer() {
      try {
           System.out.print("Customer email: ");
           String email = in.nextLine();

           System.out.print("Customer pass: ");
           String pass  = in.nextLine();

           db.deleteCustomer(email, pass);
           System.out.println("Customer has been deleted.");

      } catch (SQLException ex) {
           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   
   private void showAll() {
       try {
           ArrayList<Customer> customers = db.fetchCustomers();
           System.out.println("CUSTOMERS TABLE:");
           customers.stream().forEach( (customer) -> {
               System.out.printf(
                     "%-30s %-20s %-20s %-20s %-20s\n", 
                     customer.getEmail(), 
                     customer.getPassword(), 
                     customer.getMobile(), 
                     customer.getFirstName(), 
                     customer.getLastName()
               );
           });
       } catch (SQLException ex) {
           Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
