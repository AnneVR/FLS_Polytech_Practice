--delete from departments where id=666;

insert into departments (id, name) values
(666, 'Witchcraft Department'),
(1, 'Rocket Science Department');
--on conflict update;

insert into users (id, department_id, first_name, last_name, email_address) values
(1, 666, 'Grzegorz', 'Mertwicki', 'warlock99@moogle.lol'),
(2, 666, 'Anna', 'Lewiathanowa', 'swiftybr00m@moogle.lol'),
(3, 666, 'Katarzyna', 'Czarnokrzenska', 'pow3rwitch666@moodle.lol');