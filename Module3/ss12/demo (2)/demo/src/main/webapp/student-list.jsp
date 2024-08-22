<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 24/11/2023
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<a href="/student-servlet?action=create">Thêm mới sinh viên</a>
<h1>Danh sách sinh viên</h1>
<table border="1px">
    <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Điểm</th>
            <th>Xếp loại</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="s" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><c:out value="${s.name}"/></td>

<%--            Giới tính--%>
            <c:if test="${s.gender == true}">
                <td>Nam</td>
            </c:if>
            <c:if test="${s.gender == false}">
                <td>Nữ</td>
            </c:if>

<%--            Điểm--%>
            <td>${s.point}</td>
            <c:choose>
                <c:when test="${s.point >= 7}">
                    <td>Loại giỏi</td>
                </c:when>
                <c:when test="${s.point >= 6}">
                    <td>Loại khá</td>
                </c:when>
                <c:when test="${s.point >= 5}">
                    <td>Loại trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Loại yếu</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
