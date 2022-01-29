create table products
(
    id           bigserial primary key,
    title        varchar(255),
    price        numeric(8, 2) not null
);

insert into products (title, price)
values ('Beef', 88),
--       ('Pork', 77),
--       ('Bacon', 90),
--       ('Mutton', 105),
--       ('Duck', 90),
--       ('Donut', 15),
--       ('Waffle', 20),
--       ('Pie', 6),
--       ('Cake', 35),
--       ('Brownie', 25),
--       ('Biscuit', 38);