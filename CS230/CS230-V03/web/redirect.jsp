<%-- 
    Document   : redirect
    Created on : Mar 8, 2022, 2:51:06 PM
    Author     : PC
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
