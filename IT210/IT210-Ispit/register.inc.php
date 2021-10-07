<?php

$ime = $_POST["ime"];
$prezime = $_POST["prezime"];
$fakultet = $_POST["fakultet"];
$programski_jezik = $_POST["programski_jezik"];

$query = "INSERT INTO prijava(ime_korisnika,prezime_korisnika,fakultet,programski_jezik) VALUES('$ime','$prezime','$fakultet','$programski_jezik')";
$conn = mysqli_connect("localhost", "root", "", "ispit");
$conn->query($query);
header('Location: index.php');
