<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/16/2023
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body><h1>Create new user</h1>
<p>
    <a href="studentServlet">Back to customer list</a>
</p>
<form method="post" action="studentServlet?action=create">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Họ tên: </td>
                <td><input type="text" name="ten_hs" id="ten_hs"></td>
            </tr>
            <tr>
                <td>Ngày sinh :</td>
                <td><input type="text" name="ngay_sinh" id="ngay_sinh"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Lớp:</td>
                <td><input type="text" name="lop" id="lop"></td>
            </tr>
            <tr>
                <td>Địa chỉ:</td>
                <td><input type="text" name="dia_chi" id="dia_chi"></td>
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
