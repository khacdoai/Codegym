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
    <title>Mượn sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
</head>
<body>
<fieldset>
    <legend style="padding: 20px">Mượn sách</legend>
    <form action="/productServlet?action=create" method="post" style="padding: 20px">
        <div class="col-6">
            <label for="maMatHang" class="form-label">Mã mượn sách: </label>
            <input type=text class="form-control" id="maMatHang"  width="90px" name="maMatHang" placeholder="Ví dụ: MS-XXX">
        </div>
        <div class="col-6">
            <label for="tenMatHang" class="form-label">Tên sách: </label>
            <input type="text" class="form-control" id="tenMatHang"  name="tenMatHang"placeholder="Ví dụ: abc" value="${requestScope["theMuonSachDto"].getTenSach()}" readonly>
        </div>
        <div class="col-6">
            <label for="gia" class="form-label">tên học sinh: </label>
            <input type="text" class="form-control" id="gia" name="gia">
        </div>
        <div class="col-6">
            <label for="soLuong" class="form-label">ngày mượn: </label>
            <input type="date" class="form-control" id="soLuong" name="soLuong">

        </div>
        <div class="col-6">
            <label for="soLuong2" class="form-label">ngày trả: </label>
            <input type="date" class="form-control" id="soLuong2" name="soLuong2">

        </div>
<%--        <div class="col-6">--%>
<%--            <p>Loại khách hàng</p>--%>
<%--            <select class="form-select" aria-label="Default select example" id="loaiMatHang" name="loaiMatHang">--%>
<%--                <option value="">---chọn---</option>--%>
<%--                <c:forEach items="${loaiMatHangList}" var="lmh">--%>
<%--                    <option value="${lmh.idLoaiMatHang}" >${lmh.tenLoaiMatHang}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <div class="col-6">--%>
<%--            <p>Nhà sản xuất</p>--%>
<%--            <select class="form-select" aria-label="Default select example" id="nhaSanXuat" name="nhaSanXuat">--%>
<%--                <option value="">---Chọn---</option>--%>
<%--                <c:forEach items="${nhaSanXuatList}" var="nsx">--%>
<%--                    <option value="${nsx.getIdNhaSanXuat()}" >${nsx.getTenNhaSanXuat()}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>
<%--        </div>--%>
        <button type="submit" class="btn btn-primary" style="width: 150px; margin:20px">Submit</button>
    </form>
</fieldset>

</body>
</html>
