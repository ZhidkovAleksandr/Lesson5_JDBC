Drop database BookStorageL5;
CREATE DATABASE BookStorageL5;

USE BookStorageL5;

DROP TABLE Book;

CREATE TABLE Author(
id int auto_increment,
name varchar(25),
last_name varchar(25),
primary key(id)
);

DELETE FROM Author;

CREATE TABLE Book
(
id int auto_increment,
name varchar(25),
author_id int,
primary key(id),
foreign key(author_id)
references Author (id) 
);

drop table book;

insert into Author
(name, last_name)
values
('secondA', 'Ln2');

insert into Book
(name, author_id)
values
('test2', 2);
