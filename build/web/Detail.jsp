<%-- 
    Document   : Detail.jsp
    Created on : Jan 26, 2024, 11:45:42 PM
    Author     : toden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <h1>Car Detail</h1>
        <div><strong>CarID</strong> ${car.getCarID()}</div>
        <div><strong>CarName</strong> ${car.getCarName()}</div>
        <div><strong>Manufacter</strong> ${car.getManufacturer()}</div>
        <div><strong>Price</strong> ${car.getPrice()}</div>
        <div><strong>ReleasedYear</strong> ${car.getReleasedYear()}</div>
    </body>
</html>
