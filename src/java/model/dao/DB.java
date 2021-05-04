package model.dao;
import java.sql.Connection;

/** 
* Super class of DAO classes that stores the database information 
*  
*/

public abstract class DB {   
   //replace this string with your jdbc:derby local host url   
   protected String URL = "jdbc:derby://localhost:1527/";
   protected String dbname = "iotdb"; //name of the database   
   protected String dbuser = "isduser"; //db root user   
   protected String dbpass = "admin"; //db root password   

   //jdbc client driver - built in with NetBeans   
   protected String driver = "org.apache.derby.jdbc.ClientDriver";

   //connection null-instance to be initialized in sub-classes
   protected Connection conn; 

}
