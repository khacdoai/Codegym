<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 3/1/2024
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<a href="" class="btn btn-primary" style="margin: 15px">Thêm mới nhân viên</a>
<table class="table table-hover">
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ Tên</th>
        <th>Ngày Sinh</th>
        <th>Giới tính</th>
        <th>Số cmnd</th>
        <th>Số điện thoại</th>
        <th>Địa chỉ</th>
        <th>Chỉnh sửa</th>
    </tr>
    </thead>
    <tbody>

        <c:forEach items="${list}" var="e" varStatus="lam">
            <tr>
            <td>${lam.count}</td>
            <td>${e.getHoTen()}</td>
            <td>${e.getNgaySinh()}</td>
            <c:if test="${e.getGioiTinh() == 0}">
                <td>Nữ</td>
            </c:if>
            <c:if test="${e.getGioiTinh() == 1}">
                <td>Nam</td>
            </c:if>
            <td>${e.getSoCmnd()}</td>
            <td>${e.getSoDienThoai()}</td>
            <td>${e.getDiaChi()}</td>
                <td>
                    <div style="display:flex; align-items: center; justify-content: space-between">
                        <a class="btn btn-primary" href="/customerServlet?action=edit&ma_khach_hang=${c.ma_khach_hang}" role="button" style="margin-right: 5px" >Edit</a>
                        <button type="button" class="btn btn-danger" onclick="sendInformation('${e.getMaNhanVien()}','${e.getHoTen()}')"
                                data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Xóa
                        </button>
                    </div>
                </td>
            </tr>

        </c:forEach>
    </tbody>
</table>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form method="post" action="/EmployeeServlet?action=delete">
                <div class="modal-body">
                    <input type="hidden" id="id" name="maNhanVien">
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

</body>
</html>
