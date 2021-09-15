USE bolnica_db;
SELECT * FROM pacijenti JOIN pregled ON pacijenti.pacijentId=pregled.pacijentiID
WHERE  datumPregleda BETWEEN '2021-01-01' AND '2021-04-02';