<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/17/2023
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <title>Student list</title>
</head>
<body>
<h1>List Student</h1>
<p>
    <a href="/studentServlet?action=create">ADD NEW STUDENT</a>
</p>
<table class="table table-hover">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Ngày sinh</th>
        <th>Email</th>
        <th>Lớp</th>
        <th>Địa chỉ</th>
        <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="s" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><c:out value="${s.ten_HS}"/></td>
            <td><c:out value="${s.ngay_sinh}"/></td>
            <td><c:out value="${s.email}"/></td>
            <td><c:out value="${s.lop}"/></td>
            <td><c:out value="${s.dia_chi}"/></td>
            <td>
                <a href="/studentServlet?action=edit&id=${s.ma_HS}">edit</a>
            </td>
            <td>
                <button type="button" class="btn btn-danger" onclick="sendInformation('${s.ma_HS}','${s.ten_HS}')"
                        data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Xóa
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="/studentServlet?action=delete">
                <div class="modal-body">
                    <input type="hidden" id="ma_HS" name="ma_HS">
                    Bạn có chắc chắn muốn xóa <span id="ten_HS"></span> ?
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
    function sendInformation(ma_HS,ten_HS) {
        document.getElementById("ten_HS").innerText = ten_HS;
        document.getElementById("ma_HS").value = ma_HS;
    }
</script>
</body>
</html>
