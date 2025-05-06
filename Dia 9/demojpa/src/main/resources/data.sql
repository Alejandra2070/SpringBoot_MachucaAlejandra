insert into rol(id, name) values (1, 'User');
insert into rol(id, name) values (2, 'Admin');
insert into rol(id, name) values (3, 'Otro');


insert into personas(id, programming_language, last_name, full_name, rol_id) values(1, 'Java', 'Lizarazo', 'Maria', '1');
insert into personas(id, programming_language, last_name, full_name, rol_id) values(2, 'Java', 'Miguel', 'Luis', 2);
insert into personas(id, programming_language, last_name, full_name, rol_id) values(3, 'Kotlin', 'Ruiz', 'Adrian', 2);
insert into personas(id, programming_language, last_name, full_name, rol_id) values(4, 'Spring', 'Molina', 'Valentina', 3);
insert into personas(id, programming_language, last_name, full_name, rol_id) values(5, 'Spring', 'Ortiz', 'Zully', 3);

insert into passport(id, person_id, number, expiration) values(1, 1, 'NUM12345', '2029-10-02');
insert into passport(id, person_id, number, expiration) values(2, 2, 'NUM54321', '2032-10-02');
insert into passport(id, person_id, number, expiration) values(3, 3, 'NUM123456', '2025-10-02');

insert into project(id, name) values(1, 'Proyecto de Java'),
(2, 'Proyecto de CSharp');

insert into personas_project(persona_id, project_id) values
(1,1),
(1,2),
(2,1),
(1,2);