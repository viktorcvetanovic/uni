<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prijava</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/global.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="index.php"><img src="img/img.png"></a></li>
        <li><a class="active" href="index.php">Pocetna</a></li>
        <li><a href="show.php">Prikaz</a></li>
        <li><a href="register.php">Prijava</a></li>
        <li><a href="about.php">O nama</a></li>
    </ul>
</nav>
<div class='show_t'>
    <h1>Prijavi se</h1>
    <form action="register.inc.php" method="POST">
        <div class='container_for_new'>
            <label for="ime"><b>Ime</b></label>
            <input type="text" name="ime" required><br>
            <label for="prezime"><b>Prezime</b></label>
            <input type="text" name="prezime" required><br>
            <label for="fakultet"><b>Fakultet</b></label>
            <input type="text" name="fakultet" required><br>
            <label for="bodovi"><b>Programski jezik</b></label>
            <select name="programski_jezik">
                <option value='java'>Java</option>
                <option value='c'>C</option>
                <option value='go'>Go</option>
                <option value='python'>Python</option>
            </select><br>
            <button type="submit">Unesi</button>
        </div>

    </form>
</div>
<footer>
    <p>Author: Nikola Dimitrijevic<br>
        <a href="mailto:proba@gmail.com">example@example.com</a></p>
</footer
</body>
</html>
