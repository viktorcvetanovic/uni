<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>

<%
    String driverName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mariadb://localhost:3306/";
    String dbName = "dz04";
    String userId = "root";
    String password = "root";

    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
    <tr>

    </tr>
    <tr bgcolor="#A52A2A">
        <td><b>id</b></td>
        <td><b>Simbol</b></td>
        <td><b>Naziv</b></td>
        <td><b>Sifra</b></td>
        <td><b>Jacina</b></td>
        <td><b>Dividenda</b></td>
    </tr>
    <%
        try {
            connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM akcija";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
    %>
    <tr bgcolor="#DEB887">

        <td><%=resultSet.getString("id") %>
        </td>
        <td><%=resultSet.getString("symbol") %>
        </td>
        <td><%=resultSet.getString("name") %>
        </td>
        <td><%=resultSet.getString("price") %>
        </td>
        <td><%=resultSet.getString("volume") %>
        </td>
        <td><%=resultSet.getString("dividend") %>
        </td>

    </tr>

    <%
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>