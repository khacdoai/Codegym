<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 3/7/2024
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<fieldset>
    <legend style="padding: 20px">Product Information</legend>
    <form onsubmit="return validateFormCreate()" action="/productServlet?action=create" method="post" style="padding: 20px">
        <div class="col-6">
            <label for="maMatHang" class="form-label">Mã mặt hàng: </label>
            <input type=text class="form-control" id="maMatHang"  width="90px" name="maMatHang" placeholder="Ví dụ: MH-XXX">
        </div>
        <div class="col-6">
            <label for="tenMatHang" class="form-label">Tên mặt hàng: </label>
            <input type="text" class="form-control" id="tenMatHang"  name="tenMatHang"placeholder="Ví dụ: abc">
        </div>
        <div class="col-6">
            <label for="gia" class="form-label">Giá: </label>
            <input type="text" class="form-control" id="gia" name="gia">
        </div>
        <div class="col-6">
            <label for="soLuong" class="form-label">Số lượng: </label>
            <input type="text" class="form-control" id="soLuong" name="soLuong">

        </div>
        <div class="col-6">
            <p>Loại khách hàng</p>
            <select class="form-select" aria-label="Default select example" id="loaiMatHang" name="loaiMatHang">
                <option value="">---chọn---</option>
                <c:forEach items="${loaiMatHangList}" var="lmh">
                    <option value="${lmh.idLoaiMatHang}" >${lmh.tenLoaiMatHang}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-6">
            <p>Nhà sản xuất</p>
            <select class="form-select" aria-label="Default select example" id="nhaSanXuat" name="nhaSanXuat">
                <option value="">---Chọn---</option>
                <c:forEach items="${nhaSanXuatList}" var="nsx">
                    <option value="${nsx.getIdNhaSanXuat()}" >${nsx.getTenNhaSanXuat()}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary" style="width: 150px; margin:20px">Submit</button>
    </form>
</fieldset>
<script>
    function validateFormCreate() {
        var maMatHangRegex = /^MH-\d{3}$/;
        // var hoTenMatHangRegex = /^[\p{L}\s]{3,}$/u;
        var hoTenMatHangRegex = /^[\w\s]{3,}$/;
        // var giaRegex = /^[1-9]\d*$/;
        var giaRegex = /^\d+(\.\d+)?$/
        var soLuongRegex = /^[1-9]\d*$/;


        var maMatHang = document.getElementById("maMatHang").value;
        var tenMatHang =document.getElementById("tenMatHang").value;
        var gia = document.getElementById("gia").value;
        var soLuong = document.getElementById("soLuong").value;
        var loaiMatHang = document.getElementById("loaiMatHang").value;
        var nhaSanXuat = document.getElementById("nhaSanXuat").value;

        var isValid = true
        if(!maMatHang || !tenMatHang || ! gia || !soLuongRegex || !soLuong || !loaiMatHang || !nhaSanXuat){
            alert("Vui lòng điền đầy đủ thông tin!");
            isValid = false;
            return isValid;
        }
        if(!maMatHangRegex.test(maMatHang)){
            alert("Mã mặt hàng không hợp lệ");
            isValid = false
        }
        if(!hoTenMatHangRegex.test(tenMatHang)){
            alert("Tên mặt hàng phải nhiều hơn 3 kí tự");
            isValid = false
        }
        if(!giaRegex.test(gia)){
            alert("giá phải lớn hơn 0");
            isValid = false
        }
        if(!soLuongRegex.test(soLuong) || soLuong <= 0){
            alert("số lượng phải lớn hơn 0");
            isValid = false
        }
        return isValid;

    }

</script>


</body>
</html>
