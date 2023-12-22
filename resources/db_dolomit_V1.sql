CREATE TABLE type_of_carriage
(
    id          integer PRIMARY KEY,
    carriage    varchar(100) NOT NULL,
    description varchar(255)
);

INSERT INTO type_of_carriage(id, carriage, description)
VALUES (1, 'ЦС ЦМВ', 'Цестерны цементовозы'),
       (2, 'ХП', 'Хапры'),
       (3, 'ПВ(инв.)', 'Полувагоны');

CREATE TABLE dolomit_data
(
    id          UUID    DEFAULT gen_random_uuid() PRIMARY KEY,
    date_now    date    DEFAULT now() NOT NULL,
    zayavleno   integer DEFAULT 0,
    prinyato    integer DEFAULT 0,
    pogruzheno  integer DEFAULT 0,
    id_carriage integer REFERENCES type_of_carriage (Id)
);


INSERT INTO dolomit_data (zayavleno, prinyato, pogruzheno, id_carriage)
VALUES (1, 12, 33, 1),
       (44, 12, 33, 2),
       (65, 12, 33, 3);

create table users
(
    id       uuid        DEFAULT gen_random_uuid() PRIMARY KEY,
    email    varchar(255) NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    role     varchar(20) default 'ADMIN':: character varying,
    status   varchar(30) default 'ACTIVE':: character varying
);

insert into users(email, username, password, role, status)
values ('admin@mail.com', 'Admin Adminov', '$2a$12$fDNiTtqTXQcq8pYY/vdXVOVGgpBm4S8e6Ej2BGys372X7GvoW/mSC', 'ADMIN',
        'ACTIVE'),
       ('user@mail.com', 'Operator Operatorov', '$2a$12$Q5yxYx.Wl2fgShmUgfXJzeaZ9WMd8LxBtvjOAKZmW4Yci3lmdH3Wu',
        'OPERATOR',
        'NOACTIVE');

CREATE TABLE logDolomits
(
    id          UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    date_now    date DEFAULT now() NOT NULL,
    log_action  varchar(100)       NOT NULL,
    id_log_user UUID REFERENCES users (id),
    id_log_data UUID REFERENCES dolomit_data (id)
);


INSERT INTO logDolomits (log_action, id_log_user, id_log_data)
VALUES ('UPDATE', 'd2af7384-3c13-402a-9e9f-625257a0d0fd', '51e6b384-8ee4-4de0-a3d3-9daeea959a39'),
       ('CREATE', '64e084f7-a3bc-45fc-850e-c128b8cb1d26', '9e4244b0-5286-463e-8388-4eaf1fb5d61d')