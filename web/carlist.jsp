<%-- 
    Document   : carlist
    Created on : Jan 26, 2024, 11:18:37 PM
    Author     : toden
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Duong page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <%
        List<Car> cars = (List<Car>) request.getAttribute("carlist");
    %>
    <body>
        <jsp:include page="header.jsp" />
        
        <h1>Car List</h1>
        <a href="add">create new</a>
        <table>
            <tr>
                <th>CarId</th>
                <th>CarName</th>
                <th>Manufacturer</th>
                <th>Price</th>
                <th>ReleasedYear</th>
                <th></th>
            </tr>

            <% for (Car car : cars) {%>
            <tr>
                <td><%= car.getCarID()%></td>
                <td><%= car.getCarName()%></td>
                <td><%= car.getManufacturer()%></td>
                <td><%= car.getPrice()%></td>
                <td><%= car.getReleasedYear()%></td>
                <td>
                    <a href="edit?id=<%= car.getCarID()%>">Edit</a>
                    <a href="del?id=<%= car.getCarID()%>">Delete</a>
                    <a href="detail?id=<%= car.getCarID()%>">Detail</a>
                </td>
            </tr>
            <% }%>

        </table>
    </body>
</html>
