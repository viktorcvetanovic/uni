<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="mystyle.css">
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Viktor Cvetanovic- wrriten in Java" %>
</h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<div class="flex">
    <div>
        <h2>My favorite car</h2>
        <img src="https://carsguide-res.cloudinary.com/image/upload/f_auto%2Cfl_lossy%2Cq_auto%2Ct_default/v1/editorial/2021-Audi-RS5-Sportback-coupe-1001x565.JPG">
    </div>
    <div>
        <h3>Picture of me</h3>
        <img src="me.jpg">
    </div>

</div>

<h3>About me</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi aliquet, enim consequat tempor ornare, nisl nisl
    lacinia diam, placerat efficitur mauris sapien eu est. Morbi eget neque eu lacus tempus viverra. Ut imperdiet lacus
    ut nibh euismod fringilla. In ante dui, cursus eu suscipit in, consectetur sit amet tellus. Phasellus hendrerit
    pretium massa, eget bibendum metus. Suspendisse sed vestibulum nulla, sed condimentum metus. Proin sollicitudin at
    dui non dapibus. Etiam ipsum felis, consequat in eleifend nec, aliquam nec tellus. In quis maximus tellus, vitae
    suscipit risus.
</p>


<form method="post" action="about-servlet">
    <button type="submit">O meni</button>
</form>
</body>
</html>