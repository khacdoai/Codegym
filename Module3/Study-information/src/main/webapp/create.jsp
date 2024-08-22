<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/17/2023
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<h1> Create Student</h1>
<p>
    <a href="/studentServlet">Back to student list</a>
</p>
<form method="post" >
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="ten_HS" id="ten_HS"></td>
            </tr>
            <tr>
                <td>Ngày sinh:</td>
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
                <td>Name:</td>
                <td><input type="text" name="dia_chi" id="dia_chi"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="save"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
