create database repositorio;

use repositorio;

create table materia (
id int auto_increment primary key,
disciplina varchar(50),
assunto varchar(50),
autor varchar(50),
descricao varchar(50),
link varchar(200)
);