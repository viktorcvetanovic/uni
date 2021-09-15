USE bolnica_db;
CREATE TABLE zaposleni(
id INT AUTO_INCREMENT PRIMARY KEY,
 ime VARCHAR(10),
prezime VARCHAR(20),
godine INT(3),
odeljenje VARCHAR(20),
isGlavni TINYINT
);