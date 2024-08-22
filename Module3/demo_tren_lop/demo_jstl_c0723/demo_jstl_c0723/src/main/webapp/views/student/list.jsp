<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 1/31/2024
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<h1>Trang danh sách</h1>
<a href="/student">Thêm mới</a>
<p>${myDate}</p>
<p>
    <f:formatDate value="${myDate}" pattern="dd/MM/yyyy"></f:formatDate>
</p>

<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>gender</th>
        <th>point</th>
        <th>Rank</th>
        <th>class id</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.getName()}</td>
            <c:if test="${student.isGender()}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.isGender()}">
                <td>Nữ</td>
            </c:if>
            <td>${student.getPoint()}</td>
            <c:choose>
                <c:when test="${student.getPoint()>=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.getPoint()>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.getPoint()>=5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yêu sắc yếu</td>
                </c:otherwise>
            </c:choose>
            <td>${student.getClassId()}</td>
<%--            <td><c:out value="${student.getClassId()}"></c:out></td>--%>
        </tr>
    </c:forEach>

</table>
</body>
</html>
