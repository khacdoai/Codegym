<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 11/27/2023
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting Customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/Customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>

    <table>
        <tr>
            <td> name:</td>
            <td>${requestScope["customer"].getName()}</td>
        </tr>
        <tr>
            <td>Email: </td>
            <td>${requestScope["customer"].getEmail()}</td>
        </tr>
        <tr>
            <td>Addess: </td>
            <td>${requestScope["customer"].getAddress()}</td>
        </tr>
        <tr>
            <td><input type="submit" value="Delete customer"></td>
            <td><a href="/Customers">Back to customer list</a></td>
        </tr>
    </table>
    </fieldset>
</form>
</body>
</html>
