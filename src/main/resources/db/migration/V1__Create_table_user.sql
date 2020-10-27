create table if not exists userTable (
    ID int,
    NAME varchar(32) not null,
    EMAIL varchar(32) not null,
    CREATED_AT timestamp
);