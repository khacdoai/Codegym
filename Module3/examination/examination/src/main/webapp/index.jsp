<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <style>
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <h1 class="mt-5">Product list</h1>
    <a role="button" class="btn btn-outline-primary mb-5" href="?action=show-form-create">Add new product</a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Category</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="p" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${p.name}</td>
                <td>${p.categoryName}</td>
                <td>
                    <button class="btn btn-outline-warning">Edit</button>
                </td>
                <td>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-outline-danger"
                            onclick="sendInf('${p.name}','${p.id}')" data-bs-toggle="modal"
                            data-bs-target="#exampleModal">
                        Remove
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="?action=delete" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Remove product</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="idDel" id="idDel">
                        Are you sure to remove <span id="nameDel" class="text-danger"></span> ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Remove</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<script>
    function sendInf(name, id) {
        document.getElementById("nameDel").innerText = name;
        document.getElementById("idDel").value = id;
    }
</script>
</body>
</html>