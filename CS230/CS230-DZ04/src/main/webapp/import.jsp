<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 3/20/2022
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="import.jsp">
    Ime<br>
    <input name="name"><br>
    Simbol<br>
    <input name="symbol"><br>
    Cena<br>
    <input name="price"><br>
    Vrednost<br>
    <input name="volume"><br>
    Dividenda<br>
    <input name="dividend"><br>
    <button type="submit">Posalji</button>
</form>
<%
    try {
        String name = request.getParameter("name");
        String symbol = request.getParameter("symbol");
        String price = request.getParameter("price");
        String volume = request.getParameter("volume");
        String dividend = request.getParameter("dividend");
        if(name==null){
            return;
        }

        Class.forName("com.mysql.jdbc.Driver");// Driver to establish connection to the database
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/dz04", "root", "root"); //Create connection using your ID and Password
        Statement st1 = con1.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT * FROM akcija");
        while (rs1.next()) {

            //-----------------------------Then, Create an InsertQuery using a String:---------------------

            String InsertQuery = "insert into akcija (symbol,name,price,volume,dividend) values('"+symbol+", "+name+", "+price+", "+volume+","+dividend+"');";

            //-----------------------------Finally, Execute your Insert Query:-----------------------------

            st1.executeUpdate(InsertQuery);
        }
    } catch (Exception error) {
        System.out.println(error);
    }
%>
</body>
</html>
