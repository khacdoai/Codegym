<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 3/8/2024
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<fieldset>
    <legend style="padding: 20px">Chỉnh sửa bệnh án</legend>
    <form action="/BenhAnServlet?action=edit" method="post" style="padding: 20px">
        <input name="idProduct" id="idProduct" type="hidden" value="${requestScope["benhAnDto"].getIdBenhAn()}">
        <div class="col-6">
            <label for="maMatHang" class="form-label">Mã bệnh án: </label>
            <input type=text class="form-control" id="maMatHang"  width="90px" name="maMatHang" value="${requestScope["benhAnDto"].getMaBenhAn()}">
        </div>
        <div class="col-6">
            <label for="tenMatHang" class="form-label">Mã bệnh nhân: </label>
            <input type="text" class="form-control" id="tenMatHang"  name="tenMatHang" value="${requestScope["benhAnDto"].getMaBenhNhan()}">
        </div>
        <div class="col-6">
            <label for="tenBenhNhan" class="form-label">Mã bệnh nhân: </label>
            <input type="text" class="form-control" id="tenBenhNhan"  name="tenBenhNhan" value="${requestScope["benhAnDto"].getTenBenhNhan()}">
        </div>
        <div class="col-6">
            <label for="gia" class="form-label">Ngày ra viện: </label>
            <input type="date" class="form-control" id="gia" name="gia" value="${requestScope["benhAnDto"].getNgayNhapvien()}">
        </div>
        <div class="col-6">
            <label for="soLuong" class="form-label">Ngày Nhập viện: </label>
            <input type="date" class="form-control" id="soLuong" name="soLuong" value="${requestScope["benhAnDto"].getNgayRaVien()}">
        </div>
        <div class="col-6">
            <label for="lyDo" class="form-label">Lý do Nhập Viện : </label>
            <input type="text" class="form-control" id="lyDo" name="soLuong" value="${requestScope["benhAnDto"].getLyDoNhapVien()}">
        </div>
<%--        <div class="col-6">--%>
<%--            <p>Loại khách hàng</p>--%>
<%--            <select class="form-select" aria-label="Default select example" id="loaiMatHang" name="loaiMatHang">--%>
<%--                <option value="">---chọn---</option>--%>
<%--                <c:forEach items="${loaiMatHangList}" var="lmh">--%>
<%--                    <option value="${lmh.idLoaiMatHang}"--%>
<%--                        ${lmh.idLoaiMatHang == requestScope["productDto"].getIdLoaiMatHang() ? "selected" : ""}> ${lmh.tenLoaiMatHang}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        </div>--%>
        <button type="submit" class="btn btn-primary" style="width: 150px; margin:20px">Submit</button>
    </form>
</fieldset>


</body>
</html>