<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pocetna strana</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<form action="server.php" method="POST">
  <label >Naziv</label><br>
  <input type="text" name="naziv"><br>
  <label >Cena</label><br>
  <input type="number" name="cena" ><br><br>
  <label >Kolicina</label><br>
  <input type="number" name="kolicina"><br>
  <label >Sifra</label><br>
  <input type="number" name="sifra" ><br><br>
  <input type="submit" value="Submit">
</form> 


</body>
</html>