<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 29/11/2023
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sinh viên</h1>
<form method="post" action="/student-servlet?action=create">
    Tên: <input type="text" name="name"><br/>
    Giới tính: <input type="radio" name="gender" value="male">Nam
                <input type="radio" name="gender" value="female">Nữ <br>
    Điểm: <input type="number" name="point">
    <input type="submit" value="Thêm mới sinh viên">
</form>
</body>
</html>
