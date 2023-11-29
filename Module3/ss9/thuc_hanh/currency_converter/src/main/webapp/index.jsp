<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="/convert">
    <div>
        <h2><b>Currency Converter</b></h2>
        <label>Rate:</label><br>
        <input type="text" name="rate" placeholder="RATE" value="22000"><br>
        <label>USD: </label><br>
        <input type="text" name="usd" placeholder="USD" value="0"><br>
        <input type="submit" id = "Submit" value="Converter"/>
    </div>
</form>
</body>
</html>