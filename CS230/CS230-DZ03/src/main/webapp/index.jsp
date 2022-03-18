<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<form action="forma.jsp" method="post" target="_blank">
    <input type="checkbox" name="fit" checked="checked"/>FIT<br>
    <input type="checkbox" name="fam" checked="checked"/>FAM<br>
    <input type="checkbox" name="fdu" checked="checked"/>FDU<br>


    <input type="checkbox" name="s1" checked="checked"/>Predmet 1<br>
    <input type="checkbox" name="s2" checked="checked"/>Predmet 2<br>
    <input type="checkbox" name="s3" checked="checked"/>Predmet 3<br>
    <input type="submit" value="Izbor fakulteta">
</form>
</body>
</html>