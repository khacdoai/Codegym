<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 11/29/2023
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1> View product</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Describe:</td>
                <td>${requestScope["product"].getDescribe()}</td>
            </tr>
            <tr>
                <td>Producer</td>
                <td>${requestScope["product"].getProducer()}</td>
            </tr>
        </table>
    </fieldset>
</form>


</body>
</html>
