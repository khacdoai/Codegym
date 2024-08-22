<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/18/2023
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<h1>Product list</h1>
<p>
    <a href="/productServlet?action=create">ADD NEW USER</a>
</p>
<form method="post" action="?action=search">
    <table>
        <tr>
            <td><input type="text" name="search" id="search"></td>
            <td><input type="submit" value="search"></td>
        </tr>
    </table>
</form>
<table class="table table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantily</th>
        <th>Color</th>
        <th>Note</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="p" varStatus="loop">
        <td>${loop.count}</td>
        <td><c:out value="${p.ten}"/></td>
        <td><c:out value="${p.gia}"/></td>
        <td><c:out value="${p.soLuong}"/></td>
        <td><c:out value="${p.mauSac}"/></td>
        <td><c:out value="${p.moTa}"/></td>
    <td><c:out value="${p.tenDanhMuc}"/></td>
                        <td><a href="/productServlet?action=edit&id=${p.id}">Edit</a></td>
<%--        <td>--%>
<%--            <a class="btn btn-primary" href="/userServlet?action=edit&id=${s.id}" role="button">Edit</a>--%>
<%--        </td>--%>
<%--                        <td><a href="/productServlet?action=delete&id=${p.id}">delete</a></td>--%>
        <td>
            <button type="button" class="btn btn-danger" onclick="sendInformation('${p.id}','${p.ten}')"
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
            <form method="post" action="/productServlet?action=delete">
                <div class="modal-body">
                    <input type="hidden" id="id" name="id">
                    Bạn có chắc chắn muốn xóa <span id="ten"></span> ?
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
    function sendInformation(id,ten) {
        document.getElementById("ten").innerText = ten;
        document.getElementById("id").value = id;
    }
</script>
</body>
</html>
