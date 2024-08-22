<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 2/2/2024
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create student</h1>
<form  method="post">
<%--    Id:--%>
<%--    <input name="id"><br>--%>
    Name:
    <input id="name" oninput="checkName()" name="name"><br>
    <small id="errorName" style="color: red"></small>
    Gender:
    <input name="gender" value="true" type="radio">Nam

    <input name="gender" value="false" type="radio">Nữ<br>
    Point:
    <input name="point"><br>
    Class Id:
    <select name="classId">
<%--        <option>--chọn lớp-----</option>--%>
      <c:forEach var="cls" items="${classList}">
        <option value="${cls.id}">${cls.name}</option>
      </c:forEach>
    </select>
    <button type="submit">Save</button>
</form>
<script>
    function checkName(){
        let name = document.getElementById("name");
        if (name.length<5){
            document.getElementById("errorName").innerText ="Không để trống"
        }else {
            document.getElementById("errorName").innerText ="OK"
        }
    }

</script>
</body>
</html>
