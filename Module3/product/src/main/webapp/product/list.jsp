<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 11/29/2023
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>
<h1> Product</h1>
<p>
    <a href="/product?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Describe</td>
        <td>Produced</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
    <tr>
        <td><a href="/product?actio=view&id=${product.getId()}">${product.getName()}</a></td>
        <td>${product.getPrice()}</td>
        <td>${product.getDescribe()}</td>
        <td>${product.getProducer()}</td>
        <td><a href="/product?action=edit&id=${product.getId()}">Edit</a></td>
        <td><a href="/product?action=delete&id=${product.getId()}">Delete</a></td>
    </tr>
    </c:forEach>
</table>

</body>
</html>
