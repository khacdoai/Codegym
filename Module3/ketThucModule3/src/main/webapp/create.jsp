<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/18/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<h1>Create new product</h1>
<p>
    <a href="/productServlet">Back to product list</a>
</p>
<form method="post" action="/productServlet?action=create">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="ten" id="ten"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="gia" id="gia"></td>
            </tr>
            <tr>
                <td>Quantily:</td>
                <td><input type="text" name="soLuong" id="soLuong"></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><input type="text" name="mauSac" id="mauSac"></td>
            </tr>
            <tr>
                <td>Note:</td>
                <td><input type="text" name="moTa" id="moTa"></td>
            </tr>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value=" Add new product"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
