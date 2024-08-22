<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/17/2023
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1> Edit Student</h1>
<p>
    <a href="/studentServlet">Back to student list</a>
</p>
<c:if test="${student != null}">
    <input type="hidden" name="ma_HS" value="<c:out value='${student.ma_HS}'/>">
</c:if>
<form method="post" >
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="ten_HS" id="ten_HS" value="${requestScope["student"].getTen_HS()}" ></td>
            </tr>
            <tr>
                <td>Ngày sinh:</td>
                <td><input type="text" name="ngay_sinh" id="ngay_sinh" value="${requestScope["student"].getNgay_sinh()}" ></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" value="${requestScope["student"].getEmail()}" ></td>
            </tr>
            <tr>
                <td>Lớp:</td>
                <td><input type="text" name="lop" id="lop" value="${requestScope["student"].getLop()}" ></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="dia_chi" id="dia_chi" value="${requestScope["student"].getDia_chi()}" ></td>
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
