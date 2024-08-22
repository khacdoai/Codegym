<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 2/24/2024
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<fieldset>
    <legend style="padding: 20px">Customer Information</legend>
<form onsubmit="return validateFormCreate()" action="/customerServlet?action=create" method="post" style="padding: 20px">
    <div class="col-6">
        <label for="ho_ten" class="form-label">Họ tên khách hàng: </label>
        <input type=text class="form-control" id="ho_ten"  width="90px" name="ho_ten">
    </div>
    <div class="col-6">
        <label for="ngay_sinh" class="form-label">Ngày sinh: </label>
        <input type="date" class="form-control" id="ngay_sinh"  name="ngay_sinh">
    </div>
    <div class="col-6">
        <p>Giới tính: </p>
        <input  id="nam" name="gioi_tinh" value="1" type="radio" >Nam

        <input id="nu" name="gioi_tinh" value="0" type="radio" >Nữ<br>
    </div>
    <div class="col-6">
        <label for="so_cmnd" class="form-label">Số chứng minh nhân dân: </label>
        <input type="text" class="form-control" id="so_cmnd" name="so_cmnd">

    </div>
    <div class="col-6">
        <label for="so_dien_thoai" class="form-label">Số điện thoại: </label>
        <input type="text" class="form-control" id="so_dien_thoai" name="so_dien_thoai">

    </div>
    <div class="col-6">
        <label for="email" class="form-label">Email: </label>
        <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
    </div>
    <div class="col-6">
        <label for="dia_chi" class="form-label">Địa chỉ</label>
        <input type="text" class="form-control" id="dia_chi"  name="dia_chi">

    </div>
    <div class="col-6">
        <p>Loại khách hàng</p>
    <select class="form-select" aria-label="Default select example" id="ma-loai_khach" name="ma_loai_khach">
        <option value="">Chọn loại khách hàng</option>
        <c:forEach items="${loaiKhachList}" var="lkl">
            <option value="${lkl.ma_loai_khach}" >${lkl.ten_loai_khach}</option>
        </c:forEach>
    </select>
    </div>
    <button type="submit" class="btn btn-primary" style="width: 150px; margin:20px">Submit</button>
</form>
</fieldset>

<script>
    function validateFormCreate() {
        var maKhachHangRegex = /^KH-\d{4}$/;
        var maDichVuRegex = /^DV-\d{4}$/
        var soDienThoaiRegex = /^(84)?\+?090\d{7}$|^(84)?\+?091\d{7}$/;
        var hoTenRegex = /^[\p{L}\s]{5,}$/u;
        var soCmndRegex = /^\d{9}(?:\d{3})?$/;
        var ngaySinhRegex = /^\d{2}\/\d{2}\/\d{4}$/;
        var sotangRegex = /^[1-9]\d*$/;

        // var maKhachHangRegex = /^KH-\d{4}$/;
        // var maDichVuRegex = /^DV-\d{4}$/;
        // var soDienThoaiRegex = /^(84)?\+?090\d{7}$|^(84)?\+?091\d{7}$/;
        // var hoTenRegex = /[a-zA-Z ]{6,}$/;
        // var soCmndRegex = /^\d{9,12}$/;
        // var ngaySinhRegex = /^\d{2}\/\d{2}\/\d{4}$/;

        // var makhachHang = document.getElementById().value;
        var hoTen = document.getElementById("ho_ten").value;
        var ngaySinh = document.getElementById("ngay_sinh").value;
        var soCmnd = document.getElementById("so_cmnd").value;
        var soDienThoai = document.getElementById("so_dien_thoai").value;
        var gioiTinhNam = document.getElementById("nam").checked;
        var gioiTinhNu = document.getElementById("nu").checked
        var loaiKhachHang = document.getElementById("ma-loai_khach").value;

            var isValid = true

            if (!hoTen || !ngaySinh || !soCmnd || !soDienThoai || !gioiTinhNam && !gioiTinhNu || loaiKhachHang === "") {
                alert("Vui lòng điền đầy đủ thông tin!");
                return isValid = false;
            }
            if (!hoTenRegex.test(hoTen)) {
                alert("Họ tên không hợp lệ");
                isValid = false
            }
            // if(!maKhachHangRegex.test(makhachHang)){
            //     alert("Mã khách hàng không hợp lệ");
            //     return false
            // }
            // if(!ngaySinhRegex.test(ngaySinh)){
            //     alert("Ngày sinh không hợp lệ");
            //     isValid = false;
            // }
            // if (!gioiTinhNam && !gioiTinhNu) {
            //     alert("Vui lòng chọn giới tính!");
            //     isValid =  false;
            // }
            if (!soCmndRegex.test(soCmnd)) {
                alert("Số chứng minh không hợp lệ");
                isValid = false
            }
            if (!soDienThoaiRegex.test(soDienThoai)) {
                alert("Số điện thoại không hợp lệ")
                isValid = false
            }
            // if (!loaiKhachHang) {
            //     alert("Vui lòng chọn loại khách hàng!");
            //     isValid =  false;
            // }
            return isValid;
    }

</script>
</body>
</html>
