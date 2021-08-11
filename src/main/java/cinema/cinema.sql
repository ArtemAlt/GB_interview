create table if not exists films
(
    id_film  bigserial primary key unique not null,
    title    varchar(255)                 not null,
    duration interval                     not null
);
create table if not exists timetable
(
    id_session       bigserial primary key unique      not null,
    broadcast_time   timestamp unique                  not null, /*Будем считать что у нас один зал и в одно и тоже
                                                                   время не можем транслировать разные фильмы*/
    translation_film bigint references films (id_film) not null
);

create table if not exists ticket_type
(
    id_type bigserial primary key unique not null,
    option  varchar(50) unique           not null,
    price   integer unique               not null
);

create table if not exists sales
(
    id_sale bigserial primary key unique             not null,
    session bigint references timetable (id_session) not null,
    ticket  bigint references ticket_type (id_type)  not null
);

insert into films (title, duration)
values ('Терминатор', interval '120 minutes'),
       ('Крепкий орешек', '90 minute'),
       ('Скала', '60 minute'),
       ('Рокки', '90 minute'),
       ('Первая кровь', '120 minute');

insert into ticket_type (option, price)
values ('VIP', 500),
       ('STANDARD', 300),
       ('HOLIDAY', 400),
       ('LOWCOST', 200);

insert into timetable (broadcast_time, translation_film)
values ('2021-08-01 09:00:00', 1),
       ('2021-08-01 12:00:00', 2),
       ('2021-08-01 13:00:00', 3),
       ('2021-08-01 15:00:00', 4),
       ('2021-08-01 18:00:00', 4),
       ('2021-08-01 19:00:00', 4),
       ('2021-08-01 21:00:00', 5);

insert into sales (session, ticket)
values (1, 4),
       (1, 4),
       (1, 4),
       (1, 4),
       (1, 4),
       (1, 4),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (2, 1),
       (3, 2),
       (3, 2),
       (3, 2),
       (3, 2),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4);

insert into sales (session, ticket)
values (6, 2),
       (6, 2),
       (6, 2),
       (6, 2),
       (6, 2),
       (6, 2),
       (6, 2),
       (6, 2);

/*Расписание*/
select broadcast_time, title
from timetable
         left join films on timetable.translation_film = films.id_film;

/*Запрос по номеру сессии агрегирует количество проданных билетов и общую выручку */
select id_session, title as Фильм, count(ticket) as Всего_билетов, sum(price) as Общая_выручка
from sales
         left join timetable tmt on sales.session = tmt.id_session
         left join ticket_type tt on sales.ticket = tt.id_type
         left join films f on sales.session = f.id_film
where session = 2
group by title, id_session;


/*Выборка по каждому сеансу сколько билетов и общая сумма в порядке уменьшения выручки*/
select broadcast_time as Время_сеанса,
       count(ticket)  as Всего_билетов,
       sum(price)     as Общая_сумма
from sales
         left join timetable tmt on sales.session = tmt.id_session
         left join ticket_type tt on sales.ticket = tt.id_type
         left join films f on sales.session = f.id_film
group by broadcast_time
order by Общая_сумма desc;

/*Запрос сколько всего посмотрело фильм в расписании*/
select title as Фильм, count(ticket) as Посмотрело
from timetable
         left join sales s on timetable.id_session = s.session
         left join films f on timetable.translation_film = f.id_film
group by title;