<%-- 
    Document   : forma
    Created on : Mar 8, 2022, 2:19:45 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forma</title>
    </head>
    <body>
        <center>
            <h1>Podatci iz checkbox-ova</h1>
        </center>
    
        <ul>
            <li>
                <p> <b> FIT obelezen: </b>
                <%= request.getParameter("fit")%>
                <a href="redirect.jsp?tip_fakulteta=FIT&redirekcija=http://www.metropolitan.ac.rs/osnovne-studije/fakultet-informacionih-tehnologija/">Posetite FIT</a>
                </p>
            </li>
            <li>
                <p> <b> FAM obelezen: </b>
                <%= request.getParameter("fam")%>
                <a href="redirect.jsp?tip_fakulteta=FAM&redirekcija=http://www.metropolitan.ac.rs/osnovne-studije/fakultet-za-menadzment/">Posetite FAM</a>
                </p>
            </li>
            <li>
                <p> <b> FIT obelezen: </b>
                <%= request.getParameter("fdu")%>
                <a href="redirect.jsp?tip_fakulteta=FDU&redirekcija=http://www.metropolitan.ac.rs/fakultet-digitalnih-umetnosti-2/">Posetite FDU</a>
                </p>
            </li>
        </ul>
    </body>
</html>
