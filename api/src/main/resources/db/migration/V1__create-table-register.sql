create table register (
    id bigint not null auto_increment,
    name varchar (255) not null,
    email varchar (255) not null unique,
    cpf varchar (14) not null unique,
    tel varchar (11) not null unique,
    active tinyint not null,
    uf varchar (2) not null,
    city varchar (255) not null,
    primary key (id)
);