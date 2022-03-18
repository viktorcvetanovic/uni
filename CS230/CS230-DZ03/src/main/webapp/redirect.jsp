<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 3/18/2022
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <% String tipFakulteta = request.getParameter("tip_fakulteta");%>
    <% String redirekcija = request.getParameter("redirekcija");%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="5; URL=<%= redirekcija%>"/>
    <title>Stranica za redirektovanje</title>
</head>
<body>

<h1>Prikaz poruke</h1>
<p>Vi ste student <%= tipFakulteta%> fakulteta</p>
</body>
</html>
