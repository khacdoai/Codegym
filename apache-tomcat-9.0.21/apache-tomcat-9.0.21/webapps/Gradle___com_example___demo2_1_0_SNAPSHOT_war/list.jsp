<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/16/2023
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Studen List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<h1>Student List</h1>
<p>
    <a href="studentServlet?action=create">Create new Student</a>
</p>
<table class="table table-hover">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Ngày Sinh</th>
        <th>Email</th>
        <th>Lớp</th>
        <th>Địa chi</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="s" varStatus="loop">
        <tr>
        <td>${loop.count}</td>
        <td>${s.ten_hs}</td>
        <td>${s.ngay_sinh}</td>
        <td>${s.email}</td>
        <td>${s.lop}</td>
        <td>${s.dia_chi}</td>
       <td><a class="btn btn-primary" href="studentServlet?action=edit&id=${s.ma_hs}" role="button"> edit</a></td>
                <td>
            <button type="button" class="btn btn-danger" onclick="sendInformation('${s.ma_hs}','${s.ten_hs}')"
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
            <form method="post" action="studentServlet?action=delete">
                <div class="modal-body">
                    <input type="hidden" id="ma_hs" name="ma_hs">
                    Bạn có chắc chắn muốn xóa <span id="ten_hs"></span> ?
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
    function sendInformation(ma_hs,ten_hs) {
        document.getElementById("ten_hs").innerText = ten_hs;
        document.getElementById("ma_hs").value = ma_hs;
    }
</script>
</script>
</body>
</html>
