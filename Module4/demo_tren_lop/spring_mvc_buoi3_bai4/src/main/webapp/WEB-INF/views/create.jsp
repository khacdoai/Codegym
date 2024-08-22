<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 13/3/2024
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form action="/create" method="post">--%>
<%--    Tên: <input type="text" name="name">--%>
<%--    Email: <input type="text" name="email">--%>
<%--    <input type="submit" value="Thêm mới">--%>
<%--</form>--%>

<form:form modelAttribute="student" action="/create" method="post">
    Tên: <form:input path="name"/>
    Email: <form:input path="email"/>
<%--    Sở thích: <form:select path="hobbies" items="${hobbies}"/>--%>
    Sở thích: <form:checkboxes path="hobbies" items="${hobbies}"/>
<%--    <form:radiobuttons path="hobbies" items="${hobbies}" />--%>
    <input type="submit" value="Thêm mới">
</form:form>
</body>
</html>
