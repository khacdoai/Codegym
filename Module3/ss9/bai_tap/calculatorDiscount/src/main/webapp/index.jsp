<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/calculatorDiscount" method="post">
    <div>
        <h2><b>Calculator Discount</b></h2>
        <label>Product Desciption: </label><br>
        <input type="text" name="ProductDesciption" placeholder="Product Desciption"><br>
        <label>List Price: </label><br>
        <input type="text" name="ListPrice" placeholder="List Price"><br>
        <label>Discount Percent: </label><br>
        <input type="text" name="DiscountPercent" placeholder="Discount Percent"><br>
        <input type="submit" name="submit" value="Calculete Discount">
    </div>
</form>
</body>
</html>