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
    <title>Update product</title>
</head>
<body>

<h1>Update product</h1>
<p>
    <c:if test ='${requestScope["message"] != null}'>
        <span class="message"><${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="describe" id="describe" value="${requestScope["product"].getDescribe()}"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="producer" id="Producer" value="${requestScope["product"].getProducer()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
