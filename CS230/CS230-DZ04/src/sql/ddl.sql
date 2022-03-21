create
database dz04;
create table akcija
(
    id primary key auto_increment,
    symbol varchar(64),
    name   varchar(64),
    price  float(10),
    volume float(10),
    dividend(10)
);