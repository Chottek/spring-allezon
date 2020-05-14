create table Auctions (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    shortDesc VARCHAR(40) NOT NULL,
    description VARCHAR(256) NOT NULL,
    price DOUBLE NOT NULL,
    owner VARCHAR(20) NOT NULL,

    primary key (id)
);

create table User (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    username VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    birthdate TIMESTAMP NOT NULL,

    primary key (id)

);

create table Admin
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,

    primary key (id),
    foreign key (id) references user (id)
);


