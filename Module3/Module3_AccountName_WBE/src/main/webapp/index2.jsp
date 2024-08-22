<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="user.css">
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <link rel="stylesheet" href="cssIndex.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<div class="app">
    <header class="header">
        <nav class="header__navbar">
            <ul class="header__navbar-list">
                <li class="header__navbar-item">Đăng nhập</li>
                <li class="header__navbar-item">Đăng kí</li>
            </ul>
        </nav>
        <div class="header__search">
            <ul class="search_list">
                <li class="search">
                    <div class="header__logo">
                        Logo
                    </div>
                </li>
                <li class="search">
                    <div class="header_useName">
                        Nguyen Van A
                    </div>
                </li>
            </ul>
        </div>
    </header>
    <div class="head">
        <ul class="head__item">
            <li class="item">Home</li>
            <li class="item">Employee</li>
            <li class="item"><a href="/customerServlet">Customer</a></li>
            <li class="item">Service</li>
            <li class="item">Contract</li>
        </ul>
        <ul class="head__item">
            <li class="item-search"><input type="text"></li>
            <li class="item-search"><input type="submit" value="search"></li>
        </ul>

    </div>
    <div class="container1">
        <div class="container__left">
            <ul>
                <li> <a href="/customerServlet?action=create">Thêm mới khách hàng</a></li>
            </ul>

        </div>
        <div class="container__right">
            <h3>Customer information</h3>
            <table border="1px">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                    <th>Số CMND</th>
                    <th>Số điện thoại</th>
                    <th>Email</th>
                    <th>Địa chỉ</th>
                    <th>Loại Khách</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="c" varStatus="loop">
                    <tr>
                    <td>${loop.count}</td>
                    <td><c:out value="${c.hoTen}"/></td>
                    <td><c:out value="${c.ngaySinh}"/></td>
                    <c:if test="${c.gioiTinh == true}">
                        <td>nam</td>
                    </c:if>
                    <c:if test="${c.gioiTinh == false}">
                        <td>Nữ</td>
                    </c:if>
                    <td><c:out value="${c.soCMND}"/></td>
                    <td><c:out value="${c.SDT}"/></td>
                    <td><c:out value="${c.email}"/></td>
                    <td><c:out value="${c.diaChi}"/></td>
                    <td><c:out value="${c.loaiKhach}"/></td>
                    <td><input type="submit" value="edit"></td>
                    <td><button type="button" class="btn btn-danger" onclick="sendInformation('${c.id}','${c.hoTen}')"
                                data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Xóa
                    </button></td>
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
                function sendInformation(id,hoten) {
                    document.getElementById("name").innerText = hoten;
                    document.getElementById("id").value = id;
                }
            </script>
        </div>
    </div>
<%--    <footer class="footer">--%>
<%--        <p> Footer</p>--%>
<%--    </footer>--%>
</div>

</body>
</html>
