create database school;
use school;
create table usuario (
	id varchar(100) not null primary key,
	username varchar(100),
	password varchar(100)
);

create table alumno (
	id varchar(100) not null primary key,
	nombre varchar(100),
	ape_pat varchar(100),
	ape_mat varchar(100)
);

create table docente (
	id varchar(100) not null primary key,
	nombre varchar(100),
	ape_pat varchar(100),
	ape_mat varchar(100)
);

insert into usuario values(uuid(),'admin','admin');