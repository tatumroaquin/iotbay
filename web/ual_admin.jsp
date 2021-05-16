<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.UAL" %>
<%@page import = "model.Admin" %>
<%@page import = "model.dao.DBManager" %>
<%@page import = "java.util.ArrayList" %>
<%@page import = "java.util.ListIterator" %>
<jsp:include page="include/header.jsp"/>
 <h1 class="text-center"> Admin User Access Logs </h1>
 <div class="container">
     
        <div class="text-center mx-auto">
            <form method="GET" action="ual_admin.jsp">
             <input type="date" id="date" name="date"/>
             <input type="submit" name="submit" value="Search" class="btn btn-outline-warning">
            </form>
        </div>
 
     <table class="text-center mx-auto" width="60%">
         <tr class="mx-auto">
            <th>Staff ID</th>
            <th>Login Date</th>
            <th>Login Time</th>
            <th>Logout Date</th>
            <th>Logout Time</th>
         </tr>
     <% 
         DBManager manager = (DBManager) session.getAttribute("manager");
         Admin admin = (Admin) session.getAttribute("admin");
         ArrayList<UAL> uals = manager.fetchUALAdmin(admin);
         ListIterator<UAL> UALs_iter = uals.listIterator();
         
         String doSearch   = request.getParameter("submit");
         String dateString = request.getParameter("date");
         
         System.out.println(doSearch);
         
         if(doSearch == null) {
             while(UALs_iter.hasNext()) { %>
                <% UAL ual = (UAL) UALs_iter.next(); %>
                <tr>
                    <td><%= ual.getId() %></td>
                    <td><%= ual.getLoginDate() %></td>
                    <td><%= ual.getLoginTime() %></td>
                    <td><%= ual.getLogoutDate() %></td>
                    <td><%= ual.getLogoutTime() %></td>
                </tr>
            <% } %>
        <% } else {
                while(UALs_iter.hasNext()) { %>
                    <% UAL ual = (UAL) UALs_iter.next(); %>
                    <% if (ual.getLoginDate().toString().equals(dateString)) { %>
                        <tr>
                            <td><%= ual.getId() %></td>
                            <td><%= ual.getLoginDate() %></td>
                            <td><%= ual.getLoginTime() %></td>
                            <td><%= ual.getLogoutDate() %></td>
                            <td><%= ual.getLogoutTime() %></td>
                        </tr>
                    <% } %>
              <% } %>
          <% } %>
     </table>
 </div>

<jsp:include page="include/footer.jsp"/>
