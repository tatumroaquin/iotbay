<%-- 
    Document   : index
    Created on : 29/03/2021, 5:18:09 AM
    Author     : ormus
--%>

<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
<html>
   <head>
      <title>SELECT Operation</title>
   </head>

   <body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.cj.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/iotbaydb?useSSL=false"
         user = "root"  password = "password"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT id, email, password FROM Customers;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Password</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.id}"/></td>
               <td><c:out value = "${row.email}"/></td>
               <td><c:out value = "${row.password}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>