
insert into user (city,name,password,email,surname,phone_number,role,username, unique_number, country, address, verified, temp_password) VALUES (NULL,'nikola','$2y$12$UsUNHucr2v0COA7jkKcb1epH9p2syuD1GAwhzNIzVBJdLJ1Pd9xpu','nikola.pavlovic.e38@gmail.com',NULL,0,'REGISTERED','nikola',1,'srbija','Rahele Ferari',true, 'nikola');

insert into clinic (name, address, description, city, rating, number_of_ratings, sum_of_ratings) values ('MC Klinika','Bulevar Cara Lazara 43','Klinika za kardiologiju', 'Novi Sad',5, 1, 5);
insert into clinic (name, address, description, city, rating, number_of_ratings, sum_of_ratings) values ('Consilium','Vrsacka 12','Privatna klinika za ginekologiju', 'Novi Sad',4, 1, 4);
insert into clinic (name, address, description, city, rating, number_of_ratings, sum_of_ratings) values ('Genesis','Mise Dimitrijevica 89','Poliklinika', 'Novi Sad',5, 1, 5);


insert into doctor (name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values ('Nikola', 'Pavlovic', 5, 1, '2020-04-15', '2019-04-20', '08:00:00', '15:00:00', 1, 5);
insert into doctor (name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values ('Dejan', 'Milovanovic', 4, 1, '2020-05-10', '2019-05-20', '09:00:00', '16:00:00', 1, 4);
insert into doctor (name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values ('Vladimir', 'Petrovic', 3, 2, '2020-05-22', '2019-05-25', '08:00:00', '15:00:00', 1, 3);
insert into doctor (name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values ('Srdjan', 'Gavrilovic',2 , 2, '2020-06-11', '2019-06-18', '07:00:00', '14:00:00', 1, 2);
insert into doctor (name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values ('Djordje', 'Drazic',1 , 3, '2020-07-2', '2019-07-14', '12:00:00', '19:00:00', 1, 1);
insert into doctor (name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values ('Predrag', 'Drobac',2, 3, '2020-08-4', '2019-08-08', '13:00:00', '20:00:00', 1, 2);

insert into appointment  (appointment, reserved, doctor_id) values ('08:00:00', false, 1);
insert into appointment  (appointment, reserved, doctor_id) values ('15:00:00', false, 2);
insert into appointment  (appointment, reserved, doctor_id) values ('12:00:00', false, 3);
insert into appointment  (appointment, reserved, doctor_id) values ('08:00:00', false, 4);
insert into appointment  (appointment, reserved, doctor_id) values ('13:00:00', false, 5);
insert into appointment  (appointment, reserved, doctor_id) values ('16:00:00', false, 6);


insert into examination_type(name, price, duration, hall) values('Redovan pregled',25, 30, 4);
insert into examination_type(name, price, duration, hall) values('Analiza krvi',15, 10, 6);



insert into clinic_examination_type (clinic_id, examination_type_id) values (2,1);
insert into clinic_examination_type (clinic_id, examination_type_id) values (3,2);



insert into doctor_type_examination (doctor_id, type_examination_id) values (4,1);
insert into doctor_type_examination (doctor_id, type_examination_id) values (6,2);



insert into examination (status, duration, price, discount, hall, appointment, time, type, doctor_id, type_of_examination_id, clinic_id) values ('FREE', 30, 25, 5, 3, '2020-07-5','12:00:00','Redovan pregled', 4,1,2);
insert into examination (status, duration, price, discount, hall, appointment, time, type, doctor_id, type_of_examination_id, clinic_id) values ('FREE', 10, 15, 5, 9, '2020-07-10','15:00:00','Analiza krvi', 6,2,3);



