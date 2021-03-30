<%-- 
    Document   : index.jsp
    Created on : 27/03/2021, 12:45:45 AM
    Author     : ormus
--%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <title>SELECT MYSQL</title>
    </head>
    <body>
        <h1>SELECTING DATA</h1>
        <%!
            public class Customer {
                String DB_URL = "jdbc:mysql://localhost:3306/iotbaydb";
                String USER = "root";
                String PASS = "password";

                Connection connection = null;
                PreparedStatement selectCustomers = null;
                ResultSet result = null;
                
                public Customer(){
                    try {
                        connection = DriverManager.getConnection(DB_URL, USER, PASS);
                        selectCustomers = connection.prepareStatement(
                            "SELECT * FROM Customers"
                        );
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                };
                
                public ResultSet getCustomers(){
                    try {
                        result = selectCustomers.executeQuery();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    
                    return result;
                }
            }
        %>
        <% 
           Customer customer = new Customer();
           ResultSet customers = customer.getCustomers();
        %>
        
        <table>
            <tr>
                <th>id</th>
                <th>email</th>
                <th>password</th>
                <th>firstName</th>
                <th>lastName</th>
            </tr>
            
                <% while (customers.next()) { %>
                <tr>
                    <td><%= customers.getInt("id") %></td>
                    <td><%= customers.getString("email") %></td>
                    <td><%= customers.getString("password") %></td>
                    <td><%= customers.getString("firstName") %></td>
                    <td><%= customers.getString("lastName") %></td>
                </tr>
                <% } %>
            
        </table>
    </body>
</html>
