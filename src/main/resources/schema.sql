create table consumer
(
    id           int auto_increment
        primary key,
    name         varchar(45) null,
    surname      varchar(45) null,
    patronymic   varchar(45) null,
    phone_number varchar(45) null
);

create table orders
(
    id                    int auto_increment
        primary key,
    consumer_id           int          null,
    append_date           timestamp    not null,
    receive_plan          timestamp    null,
    receive_fact          timestamp    null,
    call_date             timestamp    null,
    active                int(10)      null,
    technic               varchar(45)  null,
    brand                 varchar(45)  null,
    model                 varchar(45)  null,
    serial_number         varchar(45)  null,
    condition_type        varchar(45)  null,
    condition_description varchar(255) null,
    order_description     varchar(255) null,
    note                  varchar(255) null,
    constraint order_consumer
        foreign key (consumer_id) references consumer (id)
            on update cascade on delete cascade
);

create index order_consumer_idx
    on orders (consumer_id);

create table user
(
    id       int auto_increment
        primary key,
    username varchar(45)  null,
    password varchar(255) null
);
