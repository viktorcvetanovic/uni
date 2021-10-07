<html>
<head>
    <link rel="stylesheet" href="css/header.css">
    <style>
        * {
            text-align: center;
        }
    </style>

    <link rel="stylesheet" href="css/global.css">
</head>
<body>
<ul>
    <li><a href="index.php"><img src="img/img.png"></a></li>
    <li><a class="active" href="index.php">Pocetna</a></li>
    <li><a href="show.php">Prikaz</a></li>
    <li><a href="register.php">Prijava</a></li>
    <li><a href="about.php">O nama</a></li>
</ul>
<div class='show_t'>
    <h1>Lista takmicara</h1>
    <?php
    $query = "SELECT * FROM ispit";
    $conn = mysqli_connect("localhost", "root", "", "ispit");
    if ($result = $conn->query($query)) {
        while ($row = $result->fetch_row()) {
            echo $row[1];
            echo $row[2];
            echo $row[3];
            echo '</br>';
        }
    }

    ?>
    <div>
        <footer>
            <p>Author: Nikola Dimitrijevic<br>
                <a href="mailto:proba@gmail.com">example@example.com</a></p>
        </footer>
</body>
</html>