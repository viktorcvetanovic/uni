<%-- 
    Document   : index
    Created on : Mar 8, 2022, 2:18:18 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="forma.jsp" method="post" target="_blank">
            <input type="checkbox" name="fit" checked="checked"/>FIT<br>
            <input type="checkbox" name="fam" checked="checked"/>FAM<br>
            <input type="checkbox" name="fdu" checked="checked"/>FDU<br>
            <input type="submit" value="Izbor fakulteta">
        </form>
    </body>
</html>
