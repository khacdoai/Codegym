<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 12/1/2023
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
              crossorigin="anonymous">
    <link rel="stylesheet" href="user.css">
</head>
<body>
<h1>List User</h1>
<p>
        <a href="/userServlet?action=create">ADD NEW USER</a>
    <a class="btn btn-primary" href="/userServlet?action=sort" role="button">Sort by name</a>
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
                <th>STT</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="s" varStatus="loop">
                <td>${loop.count}</td>
                <td><c:out value="${s.name}"/></td>
                <td><c:out value="${s.email}"/></td>
                <td><c:out value="${s.country}"/></td>
<%--                <td><a href="/userServlet?action=edit&id=${s.id}">Edit</a></td>--%>
                <td>
                    <a class="btn btn-primary" href="/userServlet?action=edit&id=${s.id}" role="button">Edit</a>
                </td>
<%--                <td><a href="/userServlet?action=delete&id=${s.id}">delete</a></td>--%>
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
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="post" action="/userServlet?action=delete">
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
