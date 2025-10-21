create database treinos;
use treinos;

create table treino(
	id int primary key auto_increment,
    nome varchar(100) not null,
    repeticoes int not null,
    series int not null,
    musculo varchar(100) not null
);
select * from treino;