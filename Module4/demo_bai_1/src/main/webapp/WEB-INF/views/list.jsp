<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 3/16/2024
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div id="wrapper">
    <div class="container">
        <div class="row justify-content-around">
            <nav class="navbar bg-info row-md-8 mt-3 ">
                <div class="container-fluid">
                    <a class="btn btn-outline-primary mx-4" role="button" href="/create" >Create student</a>
                    <form class="d-flex mx-4" role="search" action="/search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="hoTen" id="hoTen">
                        <button class="btn btn-outline-success mx-3" type="submit">Search</button>
                    </form>
                </div>
            </nav>
            <div class="row-md-8 bg-light p-3">
                <h1 class="text-center text-uppercase py-3">Student information</h1>
                <table class="table table-hover text-center bg-light">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="S" varStatus="loop">
                        <tr>
                            <td>${loop.count}</td>
                            <td>${S.getTen()}</td>
                            <td>${S.getEmail()}</td>
                            <td>${S.getDiaChi()}</td>
                            <td>
                                <a class="btn btn-outline-primary mx-3" role="button"  href="/edit?id=${S.id}">Edit</a>
                                <button type="button" class="btn btn-outline-danger" onclick="sendInformation('\'' + ${product.id} + '\', \'' + ${product.ten} + '\'')"
                                        data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="/delete">
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
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

</div>

</div>
<script>
    function sendInformation(id,name) {
        document.getElementById("name").innerText = name;
        document.getElementById("id").value = id;
    }
</script>
</div>
</body>
</html>