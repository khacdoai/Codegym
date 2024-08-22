<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/16/2023
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editor Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">

</head>
<body>
<h1>Edit student</h1>
<a href="studentServlet">Back to student list </a>
<c:if test="${student != null}">
    <input type="hidden" name="ma_hs"value="<c:out value='${student.ma_hs}'/>">
</c:if>
<form method="get">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Họ tên:</td>
                <td><input type="text" id="ten_hs" name="ten_hs"value="${requestScope["student"].getTen_hs()}"></td>
            </tr>
            <tr>
                <td>Ngày Sinh:</td>
                <td><input type="text" id="ngay_sinh" name="ngay_sinh"value="${requestScope["student"].getNgay_sinh()}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" id="email" name="email"value="${requestScope["student"].getEmail()}"></td>
            </tr>
            <tr>
                <td>lớp:</td>
                <td><input type="text" id="lop" name="lop"value="${requestScope["student"].getLop()}"></td>
            </tr>
            <tr>
                <td>Địa chỉ:</td>
                <td><input type="text" id="dia_chi" name="dia_chi"value="${requestScope["student"].getDia_chi()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>