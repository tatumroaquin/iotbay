<jsp:include page="include/header.jsp"/>
<%@ page import = "model.Admin"%>
<%@ page import = "model.Customer"%>
<%@ page import = "model.Staff"%>
<%
    String firstName = (String) session.getAttribute("firstName");
    String lastName  = (String) session.getAttribute("lastName");
    
    session.invalidate();
%>
<h1 class="text-center"> <%= firstName %> <%= lastName %> has been logged out.</h1>
<jsp:include page="include/footer.jsp"/>
