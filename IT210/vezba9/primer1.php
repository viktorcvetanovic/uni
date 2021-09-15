<?php
$ime=$_POST['ime'];
$prezime=$_POST['prezime'];

try{
    $con = new PDO("mysql:host=localhost;dbname=mydatabase", "root","");
    $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

} catch(PDOException $e){
    echo "Error: " . $e->getMessage();
    }

    $sql="INSERT INTO student (ime, prezime) VALUES ('$ime','$prezime')";
    $exc = $con->query($sql);

?>