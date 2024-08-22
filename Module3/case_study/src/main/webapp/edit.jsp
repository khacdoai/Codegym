<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 2/25/2024
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<fieldset>
    <legend style="padding: 20px">Customer Information</legend>
    <form method="post" style="padding: 20px">
        <div class="col-6">
            <label for="ho_ten" class="form-label">Họ tên khách hàng: </label>
            <input type=text class="form-control" id="ho_ten"  width="90px" name="ho_ten" value="${requestScope["customer"].getHo_ten()}">
        </div>
        <%--    fix lại type = data--%>
        <div class="col-6">
            <label for="ngay_sinh" class="form-label">Ngày sinh: </label>
            <input type="text" class="form-control" id="ngay_sinh"  name="ngay_sinh"value="${requestScope["customer"].getNgay_sinh()}">
        </div>
        <div class="col-6">
            <p>Giới tính: </p>
            <input name="gioi_tinh" value="1" type="radio" ${requestScope["customer"].getGioi_tinh() == 1 ? "checked" : ""} >Nam

            <input name="gioi_tinh" value="0" type="radio" ${requestScope["customer"].getGioi_tinh() == 0 ? "checked" : ""} >Nữ<br>
        </div>
        <div class="col-6">
            <label for="so_cmnd" class="form-label">Số chứng minh nhân dân: </label>
            <input type="text" class="form-control" id="so_cmnd" name="so_cmnd" value="${requestScope["customer"].getSo_cmnd()}">

        </div>
        <div class="col-6">
            <label for="so_dien_thoai" class="form-label">Số điện thoại: </label>
            <input type="text" class="form-control" id="so_dien_thoai" name="so_dien_thoai" value="${requestScope["customer"].getSo_dien_thoai()}">

        </div>
        <div class="col-6">
            <label for="email" class="form-label">Email: </label>
            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email" value="${requestScope["customer"].getEmail()}">

        </div>
        <div class="col-6">
            <label for="dia_chi" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="dia_chi"  name="dia_chi" value="${requestScope["customer"].getDia_chi()}">

        </div>
        <div class="col-6">
            <p>Loại khách hàng</p>
            <select class="form-select" aria-label="Default select example" name="ma_loai_khach">
                <option>Chọn loại khách hàng</option>
                <c:forEach items="${loaiKhachList}" var="lkl">
                    <option value="${lkl.ma_loai_khach}"
                            ${lkl.ma_loai_khach == requestScope["customer"].getMa_loai_khach() ? "selected" : ""}>
                            ${lkl.ten_loai_khach}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary" style="width: 150px; margin:20px">Submit</button>
    </form>
</fieldset>
</body>
</html>
