USE bolnica_db;
CREATE TABLE	pregled  (
zaposleniID INT NOT NULL,
pacijentiID INT NOT NULL,
FOREIGN KEY (zaposleniID) REFERENCES zaposleni(id),
FOREIGN KEY (pacijentiID) REFERENCES pacijenti(pacijentId),
UNIQUE (zaposleniID, pacijentiID),
datumPregleda INT,
kodReda INT PRIMARY KEY
);