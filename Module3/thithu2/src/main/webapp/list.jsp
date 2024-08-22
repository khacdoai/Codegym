<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 3/7/2024
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <title>Product List</title>
</head>
<body>
<div style="display: block">
    <nav class="navbar navbar-light bg-light justify-content-between">
        <li class="nav-item" style="padding: 25px; list-style: none; display: flex">
            <a class="navbar-brand" >Product Information</a>
            <a class="btn btn-primary" href="/productServlet?action=create" style="">Thêm mới sản phẩm</a>
        </li>
        <form method="post" action="/productServlet?action=search" class="d-flex" role="search" style="margin-right: 40px">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="nameSearch" value="${name}">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </nav>
</div>
<div style="display:block">

<table id="tableProduct"  class="table table-striped table-hover">
    <thead>
    <tr>
        <th style="text-align: center">STT</th>
        <th style="text-align: center">Mã bệnh án</th>
        <th style="text-align: center">Mã bệnh nhân</th>
        <th style="text-align: center">Ngày nhập viện</th>
        <th style="text-align: center">Ngày ra viện</th>
        <th style="text-align: center">Lý do nhập viện</th>
        <th style="text-align: center">Chỉnh sửa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="c" varStatus="loop">
        <tr>
            <td style="text-align: center">${loop.count}</td>
            <td style="text-align: center"><c:out value="${c.getMaMatHang()}"/></td>
            <td style="text-align: center"><c:out value="${c.getTenMaHang()}"/></td>
            <td style="text-align: center"><c:out value="${c.getGia()}"/></td>
            <td style="text-align: center"><c:out value="${c. getSoLuong() }"/></td>
            <td style="text-align: center"><c:out value="${c.getTenLoaiMatHang()}"/></td>
            <td style="text-align: center"><c:out value="${c.getTenNhaSanXuat()}"/></td>
            <td>
                <div style="text-align: center" style=" display:flex; align-items: center; justify-content: space-between">
                    <a class="btn btn-primary" href="/productServlet?action=edit&id=${c.getId()}" role="button" style="margin-right: 5px" >Edit</a>
                    <button type="button" class="btn btn-danger" onclick="sendInformation('${c.getId()}','${c.getTenMaHang()}')"
                            data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Xóa
                    </button>
                </div>
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
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableProduct').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</body>
</html>
