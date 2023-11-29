<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 11/25/2023
  Time: 1:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table border="1px">
    <thead>
    <tr>
        <th> Tên </th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="c" varStatus="loop">
        <tr>
        <td><c:out value="${c.ten}"/></td>
        <td><c:out value="${c.ngaySinh}"/></td>
        <td><c:out value="${c.diaChi}"/></td>
        <td>${c.anh}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>


</body>
</html>
