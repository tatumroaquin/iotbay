<jsp:include page="/ServletDBConnect"/>
<jsp:include page="/ServletCartInit"/>
<jsp:include page="include/header.jsp"/>
<% String message = (String) request.getAttribute("item_exist"); %>
<script>
    let alertMsg = "<%=message%>";
    if (alertMsg !== "null")
        alert(alertMsg);
</script>
<div class="container text-center">
    <div class="title">
        <h1>Products</h1>
        <p> We sell high demand IoT (Internet of Things) devices, network middle boxes and controllers for an affordable price.</p>
    </div>
    <jsp:include page="read_products.jsp"/>
</div>
<jsp:include page="include/footer.jsp"/>
