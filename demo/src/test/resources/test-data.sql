insert into user (id, city,name,password,email,surname,phone_number,role,username, unique_number, country, address, verified, temp_password) VALUES (100, NULL,'nikola','$2y$12$UsUNHucr2v0COA7jkKcb1epH9p2syuD1GAwhzNIzVBJdLJ1Pd9xpu','nikola.pavlovic.e38@gmail.com',NULL,0,'REGISTERED','nikola',2,'srbija','Rahele Ferari',true, 'nikola');

insert into clinic (id, name, address, description, city, rating, number_of_ratings, sum_of_ratings) values (100, 'MC Klinika','Bulevar Cara Lazara 43','Klinika za kardiologiju', 'Novi Sad',5, 1, 5);
insert into clinic (id, name, address, description, city, rating, number_of_ratings, sum_of_ratings) values (101, 'Consilium','Vrsacka 12','Privatna klinika za ginekologiju', 'Novi Sad',4, 1, 4);
insert into clinic (id, name, address, description, city, rating, number_of_ratings, sum_of_ratings) values (102, 'Genesis','Mise Dimitrijevica 89','Poliklinika', 'Novi Sad',5, 1, 5);


insert into doctor (id, name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values (100, 'Nikola', 'Pavlovic', 5, 1, '2020-04-15', '2019-04-20', '08:00:00', '15:00:00', 1, 5);
insert into doctor (id, name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values (101, 'Dejan', 'Milovanovic', 4, 1, '2020-05-10', '2019-05-20', '09:00:00', '16:00:00', 1, 4);
insert into doctor (id, name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values (102, 'Vladimir', 'Petrovic', 3, 2, '2020-05-22', '2019-05-25', '08:00:00', '15:00:00', 1, 3);
insert into doctor (id, name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values (103, 'Srdjan', 'Gavrilovic',2 , 2, '2020-06-11', '2019-06-18', '07:00:00', '14:00:00', 1, 2);
insert into doctor (id, name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values (104, 'Djordje', 'Drazic',1 , 3, '2020-07-2', '2019-07-14', '12:00:00', '19:00:00', 1, 1);
insert into doctor (id, name, surname, rating, clinic_id, vacation_from, vacation_to, working_time_from, working_time_to, number_of_ratings, sum_of_ratings) values (105, 'Predrag', 'Drobac',2, 3, '2020-08-4', '2019-08-08', '13:00:00', '20:00:00', 1, 2);

insert into appointment  (id, appointment, reserved, doctor_id) values (100, '08:00:00', false, 100);
insert into appointment  (id, appointment, reserved, doctor_id) values (101, '15:00:00', false, 101);
insert into appointment  (id, appointment, reserved, doctor_id) values (102, '12:00:00', false, 102);
insert into appointment  (id, appointment, reserved, doctor_id) values (103, '08:00:00', false, 103);
insert into appointment  (id, appointment, reserved, doctor_id) values (104, '13:00:00', false, 104);
insert into appointment  (id, appointment, reserved, doctor_id) values (105, '16:00:00', false, 105);


insert into examination_type(id, name, price, duration, hall) values(100, 'Redovan pregled',25, 30, 4);
insert into examination_type(id, name, price, duration, hall) values(101, 'Analiza krvi',15, 10, 6);



insert into clinic_examination_type (clinic_id, examination_type_id) values (100,101);
insert into clinic_examination_type (clinic_id, examination_type_id) values (101,100);



insert into doctor_type_examination (doctor_id, type_examination_id) values (100,101);
insert into doctor_type_examination (doctor_id, type_examination_id) values (104,100);



insert into examination (id, status, duration, price, discount, hall, appointment, time, type, doctor_id, type_of_examination_id, clinic_id) values (100, 'FREE', 30, 25, 5, 3, '2020-07-5','12:00:00','Redovan pregled', 100, 100, 101);
insert into examination (id, status, duration, price, discount, hall, appointment, time, type, doctor_id, type_of_examination_id, clinic_id) values (101, 'FREE', 10, 15, 5, 9, '2020-07-10','15:00:00','Analiza krvi', 103, 101, 100);



