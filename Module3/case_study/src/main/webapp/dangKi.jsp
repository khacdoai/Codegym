<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 3/4/2024
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng kí tài khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<div id="wrapper">
    <div class="container">
        <div class="row justify-content-around">
            <form action="/loginServlet?action=register" method="post" class="col-md-6 bg-light p-3 my-3">
                <h1 class="text-center text-uppercase h3 py-3">Đăng kí tài khoản</h1>
                <div class="form-group">
                    <label for="tenDangNhap">Tên đăng nhập</label>
                    <input type="text" name="tenDangNhap" id="tenDangNhap" class="form-control">
                </div>
                <div class="form-group">
                    <label for="matKhau">Mật khẩu</label>
                    <input type="password" name="matKhau" id="matKhau" class="form-control">
                </div>
                <input type="submit" value="Đăng Kí" class="btn btn-primary" style="width: 300px; margin: 20px 150px"  >
            </form>
        </div>
    </div>

</div>

</body>
</html>
