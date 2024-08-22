<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 1/31/2024
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<%--<script>--%>
<%--    function displayToast(message, color) {--%>
<%--        document.getElementById("toastContent").innerHTML = message;--%>
<%--        document.getElementById("liveToast").style.background = color;--%>
<%--        let myAlert = document.getElementById('liveToast');//select id of toast--%>
<%--        let bsAlert = new bootstrap.Toast(myAlert);//inizialize it--%>
<%--        bsAlert.show();//show it--%>
<%--    }--%>
<%--</script>--%>
<h1>Trang danh sách</h1>
<a href="/student?action=add">Thêm mới</a>
<%
    String mess = request.getParameter("mess");
    if (mess==null){
        mess ="";
    }
%>

<p ><%=mess%></p>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>gender</th>
        <th>point</th>
        <th>Rank</th>
        <th>class id</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.getName()}</td>
            <c:if test="${student.isGender()}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.isGender()}">
                <td>Nữ</td>
            </c:if>
            <td>${student.getPoint()}</td>
            <c:choose>
                <c:when test="${student.getPoint()>=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.getPoint()>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.getPoint()>=5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yêu sắc yếu</td>
                </c:otherwise>
            </c:choose>
            <td>${student.getClassId()}</td>
        </tr>
    </c:forEach>

</table>

<%--<div class="position-fixed top-0 end-5 p-3" style="z-index: 11;margin-left: 500px">--%>
<%--    <div id="liveToast" style="width: 230px; color: white; background:lightgreen ;border-radius:0%/0%;" class="toast"--%>
<%--         role="dialog" aria-live="assertive" aria-atomic="true">--%>
<%--        <div class="toast-body">--%>
<%--            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="30px" height="30px">--%>
<%--                <g id="surface1_4_">--%>
<%--                    <path style="fill:#4CAF50;"--%>
<%--                          d="M44,24c0,11.045-8.955,20-20,20S4,35.045,4,24S12.955,4,24,4S44,12.955,44,24z"/>--%>
<%--                    <path style="fill:#CCFF90;"--%>
<%--                          d="M34.602,14.602L21,28.199l-5.602-5.598l-2.797,2.797L21,33.801l16.398-16.402L34.602,14.602z"/>--%>
<%--                </g>--%>
<%--            </svg>--%>
<%--            <span id="toastContent">Nội dung hiển thị</span>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>
