    create table phone (
        id bigint not null,
        city_code varchar(255) not null,
        country_code varchar(255) not null,
        number varchar(255) not null,
        user_id bigint not null,
        primary key (id)
    )
Hibernate: 
    create table users (
        id bigint not null,
        is_active integer not null,
        created varchar(255) not null,
        email varchar(255) not null,
        last_login varchar(255) not null,
        modified varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        token varchar(255) not null,
        primary key (id)
    )