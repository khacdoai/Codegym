<%--
  Created by IntelliJ IDEA.
  User: ADMINIS
  Date: 3/16/2024
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div id="wrapper">
    <div class="container">
        <div class="row justify-content-around">
            <form:form modelAttribute="student" class="col-md-6 bg-light p-3 my-3" method="post" action="/edit">
                <h1 class="text-center text-uppercase py-3">Student information</h1>
                <div class="form-group">
                    <label for="id" class="my-2">Id</label>
                    <form:input path="id" cssClass="form-control" readonly="true"/>
                </div>
                <div class="form-group">
                    <label for="hoTen" class="my-2">Name</label>
                    <form:input path="ten" cssClass="form-control" id="hoTen"/>
                </div>
                <div class="form-group">
                    <label for="email" class="my-2">Email</label>
                    <form:input path="email" cssClass="form-control" id="email"/>
                </div>
                <div class="form-group">
                    <label for="diaChi" class="my-2">Address</label>
                    <form:input path="diaChi" cssClass="form-control" id="diaChi"/>
                </div>
                <div class="text-center my-4">
                    <input class="btn btn-outline-primary mx-5 btn-block" type="submit" value="Save">
                    <a href="/" role="button" class="btn btn-outline-danger btn-block">Back to list</a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
