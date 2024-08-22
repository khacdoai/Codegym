<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 1/31/2024
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer list</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <link rel="stylesheet" href="home.css">
    <style>
        header ul{
            list-style: none;
            display: flex;
            justify-content: space-between;
            margin: 20px;
        }

    </style>
</head>
<body>
<div class="container-fluid" style="padding: 0">
    <div class="row header" >
        <div class="grid">
            <ul style="display: flex; list-style: none; justify-content: space-between; margin: 0">
                <li style="margin: 30px">logo</li>
                <li style="margin: 30px"><a href="/loginServlet?action=login">Đăng nhập</a></li>
            </ul>
        </div>
    </div>
    <div class="row navbar" >
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left: 80px">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item" style="margin-left: 50px">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item" style="margin-left: 50px">
                        <a class="nav-link" href="/employeeServlet">Employee</a>
                    </li>
                    <li class="nav-item" style="margin-left: 50px">
                        <a class="nav-link" href="/customerServlet">Customer</a>
                    </li>
                    <li class="nav-item" style="margin-left: 50px">
                        <a class="nav-link" href="#">Service</a>
                    </li>
                    <li class="nav-item" style="margin-left: 50px">
                        <a class="nav-link" href="#">Contract</a>
                    </li>

                </ul>
                <form method="post" action="?action=search" class="d-flex" role="search" style="margin-right: 40px">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="ho_ten" value="${ho_ten}">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    </div>
    <div class="row content" >
        <div class="col-2 left">
            <a href="/customerServlet?action=create" class="btn btn-primary" style="margin-bottom: 10px">Thêm mới khách hàng</a><br>
            <a href="/customerServlet?action=arrange" class="btn btn-primary">Sắp xếp</a>
        </div>
        <div class="col-10 right">
            <h1 style="text-align: center">Customer Information</h1>
            <table id="tableCustomer"  class="table table-striped table-hover">
                <thead>
                <tr>
                    <th style="text-align: center">STT</th>
                    <th style="text-align: center">Họ tên</th>
                    <th style="text-align: center">Ngày sinh</th>
                    <th style="text-align: center">Giới tính </th>
                    <th style="text-align: center">Số chứng minh</th>
                    <th style="text-align: center">Số điện thoại</th>
                    <th style="text-align: center">Email</th>
                    <th style="text-align: center">Địa chỉ</th>
                    <th style="text-align: center">Loại khách hàng</th>
                    <th style="text-align: center">Chỉnh sửa</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="c" varStatus="loop">
                    <tr>
                    <td>${loop.count}</td>
                    <td><c:out value="${c.getHo_ten()}"/></td>
                    <td><c:out value="${c.ngay_sinh}"/></td>
                    <c:if test="${c.getGioi_tinh() ==0}">
                        <td>Nữ</td>
                    </c:if>
                    <c:if test="${c.getGioi_tinh() ==1}">
                        <td>Nam</td>
                    </c:if>
                    <td><c:out value="${c.getSo_cmnd()}"/></td>
                    <td><c:out value="${c.getSo_dien_thoai()}"/></td>
                    <td><c:out value="${c.email}"/></td>
                    <td><c:out value="${c.dia_chi}"/></td>
                    <td><c:out value="${c.getTen_loai_khach()}"/></td>
                    <td>
                        <div style="display:flex; align-items: center; justify-content: space-between">
                        <a class="btn btn-primary" href="/customerServlet?action=edit&ma_khach_hang=${c.ma_khach_hang}" role="button" style="margin-right: 5px" >Edit</a>
                        <button type="button" class="btn btn-danger" onclick="sendInformation('${c.ma_khach_hang}','${c.getHo_ten()}')"
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
                        <form method="post" action="/customerServlet?action=delete">
                            <div class="modal-body">
                                <input type="hidden" id="id" name="ma_khach_hang">
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
    <div class="row footer" >
            <p style="text-align: center">footer</p>
    </div>
</div>
<script>
    function sendInformation(id,name) {
        document.getElementById("name").innerText = name;
        document.getElementById("id").value = id;
    }
</script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 6
        } );
    } );
</script>

</body>
</html>
