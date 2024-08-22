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
            <form action="?action=edit" method="post" >

                <div class="mb-2">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" required class="form-control" id="name" name="name" value="${product.name}">
                </div>
                <div class="mb-2">
                    <label for="price" class="form-label">Price:</label>
                    <input type="text" required class="form-control" id="price" name="price" value="${product.getPrice()}">
                </div>

                <div class="mb-2">
                    <label for="quantity" class="form-label">Quantity:</label>
                    <input type="text" required class="form-control" id="quantity" name="quantity" value="${product.quantity}">
                </div>

                <div class="mb-2">
                    <label for="color" class="form-label">Color:</label>
                    <input type="text" required class="form-control" id="color" name="color" value="${product.color}">
                </div>
                <div class="mb-2">
                    <label for="moTa" class="form-label">Color:</label>
                    <input type="text" required class="form-control" id="moTa" name="describe" value="${product.moTa}">
                </div>
                <div class="mb-2">
                    <div class="row">
                        <div class="col-lg-1">
                            <label for="id_category" class="form-label">Category:</label>
                        </div>
                        <div class="col-lg-6">
                            <%--                           Lưu ý đặt name tại select thay vì đặt ở option--%>
                            <select class="form-select" name="id_category" id="id_category" >
                                <c:forEach var="c" items="${list}" >
                                    <option value="${c.idCategory}"
                                        ${c.getIdCategory() == requestScope["product"].category.getIdCategory() ? "selected" : ""}>${c.nameCategory}</option>
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
