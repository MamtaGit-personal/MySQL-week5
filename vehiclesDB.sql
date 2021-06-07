create database if not exists vehicles;
use vehicles;


drop table if exists vehicles;

CREATE TABLE vehicles(
	id int(11) not null auto_increment,
	model varchar(20) not null,
	trim varchar(15) not null,
	price float,
	status varchar(10),
	primary key(id)
);


INSERT INTO vehicles(model, trim, price, status) VALUES("Jetta", "S", 1200, "unsold");
INSERT INTO vehicles(model, trim, price, status) VALUES("Jetta", "SE", 1500, "unsold");
INSERT INTO vehicles(model, trim, price, status) VALUES("Jetta", "SEL", 1700, "unsold");

INSERT INTO vehicles(model, trim, price, status) VALUES("Tiguan", "SE", 1800, "unsold");
INSERT INTO vehicles(model, trim, price, status) VALUES("Tiguan", "S", 1600, "unsold");
INSERT INTO vehicles(model, trim, price, status) VALUES("Tiguan", "S", 1600, "unsold");

INSERT INTO vehicles(model, trim, price, status) VALUES("Jetta", "S", 1200, "unsold");