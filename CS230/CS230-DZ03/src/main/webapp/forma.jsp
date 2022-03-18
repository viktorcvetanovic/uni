<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 3/13/2022
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
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
            <% String fit= request.getParameter("fit");%>
            <%=fit==null?"":"<a href=\"redirect.jsp?tip_fakulteta=FIT&redirekcija=http://www.metropolitan.ac.rs/osnovne-studije/fakultet-informacionih-tehnologija/\">Posetite FIT</a>\n"%>
        </p>
    </li>
    <li>
        <p> <b> FAM obelezen: </b>
            <% String fam=request.getParameter("fam");%>
            <%=fam==null?"":"<a href=\"redirect.jsp?tip_fakulteta=FAM&redirekcija=http://www.metropolitan.ac.rs/osnovne-studije/fakultet-za-menadzment/\">Posetite FAM</a>\n"%>
        </p>
    </li>
    <li>
        <p> <b> FIT obelezen: </b>
            <% String fdu= request.getParameter("fdu");%>
            <%=fdu==null?"":"<a href=\"redirect.jsp?tip_fakulteta=FDU&redirekcija=http://www.metropolitan.ac.rs/fakultet-digitalnih-umetnosti-2/\">Posetite FDU</a>\n" %>

        </p>
    </li>
    <li>
        <b>Svi predmeti:</b><br>
        <%="Predmet1 "+request.getParameter("s1")%><br>
        <%="Predmet2 "+request.getParameter("s2")%><br>
        <%="Predmet3 "+request.getParameter("s3")%><br>
    </li>
</ul>
</body>
</html>