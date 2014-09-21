drop table person if exists;
create table person(id int primary key auto_increment, name char, age int);

insert into person(name, age) values ('Mihai', 30);
insert into person(name, age) values ('Alina', 33);
insert into person(name, age) values ('Duke', 19);
insert into person(name, age) values ('Gabriela', 24);
insert into person(name, age) values ('Andreea', 25);