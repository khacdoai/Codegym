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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<a class="btn btn-outline-primary" href="/student-servlet?action=create">Thêm mới sinh viên</a>
<h1>Danh sách sinh viên</h1>
<table class="table table-hover">
    <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Điểm</th>
            <th>Xếp loại</th>
            <th>Hành động</th>
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
            <td>
                <button type="button" class="btn btn-danger" onclick="sendInformation('${s.id}','${s.name}')"
                        data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Xóa
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="/student-servlet?action=delete">
                <div class="modal-body">
                    <input type="hidden" id="id" name="id">
                    Bạn có chắc chắn muốn xóa <span id="name"></span> ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Xác nhận</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<script>
    function sendInformation(id,name) {
       document.getElementById("name").innerText = name;
       document.getElementById("id").value = id;
    }
</script>
</body>
</html>
