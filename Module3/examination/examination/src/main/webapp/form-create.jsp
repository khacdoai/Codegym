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
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <h1 class="mt-5">Add new product</h1>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <form action="?action=create" method="post" >
                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" required class="form-control" id="name" name="name">
                </div>
                <div class="mb-3">
                    <div class="row">
                        <div class="col-lg-1">
                            <label for="category" class="form-label">Category:</label>
                        </div>
                        <div class="col-lg-6">
<%--                           Lưu ý đặt name tại select thay vì đặt ở option--%>
                            <select class="form-select" name="categoryId" id="category" >
                                <c:forEach var="c" items="${list}" >
                                    <option value="${c.id}">${c.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="mb-3 float-end">
                    <button type="submit" class="btn btn-outline-success">Create</button>
                </div>
            </form>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
