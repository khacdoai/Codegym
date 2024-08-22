<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/1/2023
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new user</title>
</head>
<body>
<h1>Create new user</h1>
<p>
    <a href="/userServlet">Back to customer list</a>
</p>
<form method="post" action="/userServlet?action=create">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" name="country" id="country"></td>
            </tr>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add new user"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
