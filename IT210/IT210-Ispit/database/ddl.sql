CREATE
DATABASE `ispit`;
CREATE TABLE `prijava`
(
    id                INT primary key auto_increment,
    ime_korisnika     varchar(128),
    prezime_korisnika varchar(128),
    fakultet          varchar(128),
    programski_jezik  varchar(128),
);