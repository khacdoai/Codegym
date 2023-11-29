<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/calculator" method="post">
    <h1>Simple Calculator</h1>
    <fieldset>
        <legend>Calculate</legend>
        <table>
            <tr>
                <td>Fist operand</td>
                <td><input type="text" name="fist-operand"></td>
            </tr>
            <tr>
                <td>Operator</td>
                <td>
                    <select name="operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Second operand</td>
                <td><input type="text" name="second-operand"></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="Calculate"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>