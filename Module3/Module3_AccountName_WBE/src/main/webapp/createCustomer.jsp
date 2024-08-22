<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/14/2023
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>:</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" name="country" id="country"></td>
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
