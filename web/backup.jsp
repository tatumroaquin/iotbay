
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customer" %>

<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <style>
            td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Welcome Page</h1>
        <button><a href="main.jsp">Main Page</a></button>
        <%
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
        %>
        <div align="center">
        <table border="1 solid black" width="50%">
            <tr>
                <th>Email</th>
                <th>Password</th>
                <th>firstName</th>
                <th>lastName</th>
            </tr>
            <tr>
                <td><%= email %></td>
                <td><%= password %></td>
                <td><%= firstName %></td>
                <td><%= lastName %></td>
            </tr>
        </table>
        </div>
        <% 
            Customer customer = new Customer(email, password, firstName, lastName);
            session.setAttribute("customer", customer);
        %>
        
        <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/iotbaydb?useSSL=false"
         user = "root"  password = "password"/>
       
        <sql:update dataSource = "${snapshot}" var = "result">
         INSERT INTO Customers (email, password, firstName, lastName) VALUES (?,?,?,?);
         <sql:param value="${param.email}" />
         <sql:param value="${param.password}" />
         <sql:param value="${param.fname}" />
         <sql:param value="${param.lname}" />
        </sql:update>
    </body>
</html>
