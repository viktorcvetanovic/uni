<?php
try{
    $con = new PDO("mysql:host=localhost;dbname=mydatabase", "root","");
    $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

} catch(PDOException $e){
    echo "Error: " . $e->getMessage();
    }

    $sql="SELECT + FROM student";
    $exc = $con->query($sql);

    $nbrow = 0;
    echo "<table border=1><th>Ime</th><th>Prezime</th>";
    while ($row = $exc->fetch()){
        echo "<tr><td>" . $row['ime'] . "</td></td>" . $row['prezime'] . "</td></tr>";
        $nbrow++;
            }
            echo "<tr><td colspan=2>Ukupno: " .$nbrow . " studenata</td></tr></table>";
            echo "<br/><a href=primer1.html>Unos nove adrese<a/>";
            ?>