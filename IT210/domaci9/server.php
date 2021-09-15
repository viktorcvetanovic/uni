
    <?php
    $name= $_REQUEST['naziv'];
    $cena=$_REQUEST['cena'];
    $kolicina=$_REQUEST['kolicina'];
    $sifra=$_REQUEST['sifra'];
##########server-config################
    $servername="127.0.0.1";
    $username="root";
    $password="root";
    $dbname="garderoba";
############################
    $conn = new mysqli($servername, $username, $password, $dbname);
    $sql="INSERT INTO modeli (cena,kolicina,sifra) VALUES
        ($cena,$kolicina,$sifra);"
    ?>