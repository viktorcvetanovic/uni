USE bolnica_db;
SELECT * FROM pregled
WHERE datumPregleda >= DATE(NOW()) - INTERVAL 7 DAY;