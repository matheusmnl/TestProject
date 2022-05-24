create schema if not exists server;

create table servers.server (
id bigserial primary key,
user_identifier varchar(100) not null,
date timestamp not null,
total float not null
);

create table