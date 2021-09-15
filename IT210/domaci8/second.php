<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    

    <?php 
    $zbir=0;
    for ($x = 0; $x <= 100; $x++) {
        if($x%2!=0){
        $zbir+=$x   ; 
        }
      }
      echo "<h1>Zbir je:$zbir </h1>"
    ?>
</body>
</html>