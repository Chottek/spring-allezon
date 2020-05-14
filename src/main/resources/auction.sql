create table Auctions (
    id BIGINT NOT NULL,
    name VARCHAR(20) NOT NULL,
    shortDesc VARCHAR(40) NOT NULL,
    description VARCHAR(256) NOT NULL,
    price DOUBLE NOT NULL,
    owner VARCHAR(20) NOT NULL,

    primary key (id)

);