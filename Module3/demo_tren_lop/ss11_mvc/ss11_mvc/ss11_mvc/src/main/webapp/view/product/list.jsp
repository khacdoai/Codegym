<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 2/2/2024
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String mess = request.getParameter("mess");
    if(mess == null){
        mess="";
    }
%>
<html>
<head>
    <title>Product Management Application</title>
    <c:import url="../layout/Bootstrap.jsp"></c:import>
</head>
<body>
<center>
    <h1>Product Management</h1>
</center>
<div class="d-flex justify-content-between">
    <div class="ms-5">
        <button class="btn btn-outline-secondary" onclick="window.location.href='/product?action=add'">Add New</button>
    </div>
    <div class="me-5">
        <form class="d-flex" role="search" method="post" action="/product?action=search">
            <input type="search" class="form-control me-2" placeholder="Search" aria-label="Search" name="valueSearch" value="${valueChoose}">
            <button type="submit" class="btn btn-outline-secondary">Search</button>
        </form>
    </div>

</div>
<div align="center">
    <table border="1" cellpadding="5" class="table table-striped">
        <tr>
            <th>STT</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>Country</th>
            <th>DESCRIPTION</th>
            <th>ACTION</th>
        </tr>
        <c:forEach var="product" items="${productList}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()} VND</td>
                <td>${product.getCountry()}</td>
                <td>${product.getDescription()}</td>
                <td>

                    <button class="btn btn-outline-success" onclick="window.location.href='/product?action=update&id=${product.id}'">Edit</button>
                <%--                    <a href="/product?action=delete&id=${product.id}">Delete</a>--%>
                    <button type="button" onclick="getInfoProduct(${product.getId()},'${product.getName()}')" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<!-- toast Message-->
<button type="button" class="btn btn-primary" id="liveToastBtn" style="display: none
">Show live toast</button>
<div class="toast-container position-fixed bottom-0 end-0 p-3">
    <div id="liveToast" class="toast bg-info-subtle" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
<%--          <img src="..." class="rounded me-2" alt="...">--%>
            <strong class="me-auto">Notification</strong>
            <small><span id="notificationTime">now</span></small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
            <span id="mess"><%=mess%></span>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/product?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Warning</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" name="deleteId" id="deleteIdProduct" hidden>
                    <span>Delete </span><span id="deleteProductName"></span><span> ?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-warning" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-outline-success">Confirm</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    mess= document.getElementById("mess").textContent;
   const toastTrigger = document.getElementById('liveToastBtn')
   const toastLiveExample = document.getElementById('liveToast')
   if (toastTrigger) {
       const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample)
       if(!(mess ==="")){
           toastBootstrap.show()
       }
   }

   function getInfoProduct(id,name){
    document.getElementById("deleteProductName").innerText = name;
    document.getElementById("deleteIdProduct").value=id;
   }
</script>
</body>
</html>
