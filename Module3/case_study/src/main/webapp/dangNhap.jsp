<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 2/28/2024
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
    <div id="wrapper">
        <div class="container">
            <div class="row justify-content-around">
                <form action="/loginServlet?action=login" method="post" class="col-md-6 bg-light p-3 my-3">
                    <h1 class="text-center text-uppercase h3 py-3">Đăng Nhập</h1>
                    <div class="form-group">
                        <label for="matKhauLogin">Tên đăng nhập</label>
                        <input type="text" name="tenDangNhapLogin" id="tenDangNhapLogin" class="form-control" placeholder="Nhập tên tài khoản">
                    </div>
                    <div class="form-group">
                        <label for="matKhauLogin">Mật khẩu</label>
                        <input type="password" name="matKhauLogin" id="matKhauLogin" class="form-control" placeholder="Nhập mật khẩu">
                    </div>
                    <%
                        String mess = request.getParameter("mess");
                        if(mess == null){
                            mess ="";
                        }
                    %>
                    <p style="color: red; padding: 2px"><%=mess%></p>
                    <div style="display: flex">
                    <input type="submit" value="Đăng Nhập" class="btn btn-primary" style="width: 200px; margin: 25px ; margin-left: 90px"  >
                    <a href="/loginServlet?action=register" class="btn btn-primary"style="width: 200px; margin: 25px">Đăng kí</a>
                    </div>
                </form>
            </div>
        </div>

    </div>

</body>
</html>
