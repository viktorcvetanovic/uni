create database se211;
use  se211;

create table car(
car_id int primary key auto_increment,
brand varchar(128),
model varchar(128)
);

create table user(
user_id int primary key auto_increment,
username varchar(128),
email varchar(128),
password varchar(64)
);



create table post(
post_id int primary key auto_increment,
header varchar(256),
body varchar(1024),
car_fk INT,
user_fk INT,
mark_fk INT 
);

CREATE TABLE mark(
mark_id INT PRIMARY KEY AUTO_INCREMENT,
mark_value INT

);

CREATE TABLE commnet(
comment_id INT PRIMARY KEY AUTO_INCREMENT,
content VARCHAR(256)
);

ALTER TABLE post ADD CONSTRAINT fk_post_user FOREIGN KEY(`user_fk`) REFERENCES user(`user_id`);
ALTER TABLE post ADD CONSTRAINT fk_post_car FOREIGN KEY(`car_fk`) REFERENCES car(`car_id`);
ALTER TABLE post ADD CONSTRAINT fk_post_mark FOREIGN KEY(`mark_fk`) REFERENCES mark(`mark_id`);
