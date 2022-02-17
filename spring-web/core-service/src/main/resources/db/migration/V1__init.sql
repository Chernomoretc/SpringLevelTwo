create table product_category
(
   id          bigserial primary key,
   name        varchar(255) not null
);

insert into product_category (name)
values ('meat'),
       ('pastry');

create table products
(
    id           bigserial primary key,
    title        varchar(255),
--    category_id  bigint not null references product_category (id),
    price        int,
    created_at   timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp
);

insert into products (title, price)
values ('Beef', 88),
       ('Pork', 77),
       ('Bacon', 90),
       ('Mutton', 105),
       ('Duck', 90),
       ('Donut', 15),
       ('Waffle', 20),
       ('Pie', 66),
       ('Cake', 35),
       ('Brownie', 25),
       ('Biscuit', 38);


create table orders
(
    id          bigserial primary key,
    username    varchar(255) not null,
    total_price int    not null,
    address     varchar(255),
    phone       varchar(255),
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table order_items
(
    id                bigserial primary key,
    product_id        bigint not null references products (id),
    order_id          bigint not null references orders (id),
    quantity          int    not null,
    price_per_product int    not null,
    price             int    not null,
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);

insert into orders (username, total_price, address, phone)
values ('bob', 200, 'address', '12345');

insert into order_items (product_id, order_id, quantity, price_per_product, price)
values (1, 1, 2, 100, 200);
