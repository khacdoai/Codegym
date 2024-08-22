<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 13/3/2024
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<a href="/create">Thêm mới</a>
<p>${msg}</p>
<table class="table table-hover">
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="student" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
