drop table if exists card CASCADE;
create table card
(
    id           Integer generated by default as identity,
    name         varchar(255),
    phone varchar(255),
    company      varchar(255),
    primary key (id),
    unique key card_name_UNIQUE (name)
);