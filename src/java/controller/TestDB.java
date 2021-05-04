package controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import model.dao.*;

public class TestDB {
    /*
    private DBConnector connector;
    private Connection conn;
    private DBManager db;
    */
   private static Scanner in = new Scanner(System.in);
   /*
   public TestDB() {
       try {
           this.connector = new DBConnector();
           this.conn = connector.openConnection();
           this.db = new DBManager(conn);
       } catch (ClassNotFound) {
           Logger.getLogger(TestDB.class.getName().log(Leve.SEVERE, null, ))
       }
   }*/

   public static void main(String[] args) {
       
       try {
           DBConnector connector = new DBConnector();
           Connection conn = connector.openConnection();
           DBManager db = new DBManager(conn);

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

         connector.closeConnection();
      } catch (ClassNotFoundException | SQLException ex) {
         Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
