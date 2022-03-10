<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        * {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Login strana</h1>
<br/>
<form action="/login-servlet" method="post">
    Username:<br>
    <input name="username"><br>
    Password:<br>
    <input name="password" type="password"><br>
    <button type="submit">Login</button>
</form>
</body>
</html>