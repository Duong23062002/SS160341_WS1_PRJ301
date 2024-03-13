<%-- 
    Document   : edit
    Created on : Jan 26, 2024, 11:35:18 PM
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
        <h1>Update Car</h1>
        <form action="edit" method="post" style="border: solid 1px; border-radius: 10%; padding: 15px; font-size: 150%; display: inline-block">
            <input name="id" hidden readonly value="${car.getCarID()}"/>
            <div>
                <label>CarName</label><br /><br />
                <input style="padding: 10px; width: 300px" name="name" required value="${car.getCarName()}"/><br /><br />
            </div>
            <div>
                <label>Manufacturer</label><br /><br />
                <input style="padding: 10px; width: 300px" name="manu" required value="${car.getManufacturer()}"/><br /><br />
            </div>
            <div>
                <label>Price</label><br /><br />
                <input style="padding: 10px; width: 300px" name="price" type="number" step="0.01" required value="${car.getPrice()}"/><br /><br />
            </div>
            <div>
                <label>ReleasedYear</label><br /><br />
                <input style="padding: 10px; width: 300px" name="year" type="number" min="1900" max="2999" required value="${car.getReleasedYear()}"/><br /><br />
            </div>
                    
            <button style="padding: 10px; font-size: 100%">Save</button>
        </form>
    </body>
</html>
