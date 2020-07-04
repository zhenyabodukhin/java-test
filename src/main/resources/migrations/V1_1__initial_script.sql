create table m_room
(
    id           bigserial                                     not null
        constraint room_pk
            primary key,
    name         varchar(255)                                  not null,
    country_name varchar(255)                                  not null,
    light        varchar(255) default 'Off'::character varying not null
);

alter table m_room
    owner to postgres;

create unique index room_id_uindex
    on m_room (id);

create unique index room_name_uindex
    on m_room (name);

create unique index room_name_uindex_2
    on m_room (name);