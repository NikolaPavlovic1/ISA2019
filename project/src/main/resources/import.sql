
insert into korisnik (grad,ime,password,email,prezime,broj_telefona,role,username, jedinstveni_broj, drzava, adresa, verifikovan, pom_lozinka) VALUES (NULL,'nikola','$2y$12$UsUNHucr2v0COA7jkKcb1epH9p2syuD1GAwhzNIzVBJdLJ1Pd9xpu','nikola.pavlovic.e38@gmail.com',NULL,0,'REGISTROVAN','nikola',1,'srbija','Rahele Ferari',true, 'nikola');

insert into klinika (ime, adresa, opis, grad, ocjena, broj_ocena, zbir_ocena) values ('MC Klinika','Bulevar Cara Lazara 43','Klinika za kardiologiju', 'Novi Sad',5, 1, 5);
insert into klinika (ime, adresa, opis, grad, ocjena, broj_ocena, zbir_ocena) values ('Consilium','Vrsacka 12','Privatna klinika za ginekologiju', 'Novi Sad',4, 1, 4);
insert into klinika (ime, adresa, opis, grad, ocjena, broj_ocena, zbir_ocena) values ('Genesis','Mise Dimitrijevica 89','Poliklinika', 'Novi Sad',5, 1, 5);


insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do, broj_ocena, zbir_ocena) values ('Nikola', 'Pavlovic', 5, 1, '2020-04-15', '2019-04-20', '08:00:00', '15:00:00', 1, 5);
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do, broj_ocena, zbir_ocena) values ('Dejan', 'Milovanovic', 4, 1, '2020-05-10', '2019-05-20', '09:00:00', '16:00:00', 1, 4);
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do, broj_ocena, zbir_ocena) values ('Vladimir', 'Petrovic', 3, 2, '2020-05-22', '2019-05-25', '08:00:00', '15:00:00', 1, 3);
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do, broj_ocena, zbir_ocena) values ('Srdjan', 'Gavrilovic',2 , 2, '2020-06-11', '2019-06-18', '07:00:00', '14:00:00', 1, 2);
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do, broj_ocena, zbir_ocena) values ('Djordje', 'Drazic',1 , 3, '2020-07-2', '2019-07-14', '12:00:00', '19:00:00', 1, 1);
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do, broj_ocena, zbir_ocena) values ('Predrag', 'Drobac',2, 3, '2020-08-4', '2019-08-08', '13:00:00', '20:00:00', 1, 2);

insert into termin  (termin, zauzet, ljekar_id) values ('08:00:00', false, 1);
insert into termin  (termin, zauzet, ljekar_id) values ('15:00:00', false, 2);
insert into termin  (termin, zauzet, ljekar_id) values ('12:00:00', false, 3);
insert into termin  (termin, zauzet, ljekar_id) values ('08:00:00', false, 4);
insert into termin  (termin, zauzet, ljekar_id) values ('13:00:00', false, 5);
insert into termin  (termin, zauzet, ljekar_id) values ('16:00:00', false, 6);


insert into tip_pregleda(ime, cijena, trajanje, sala) values('Redovan pregled',25, 30, 4);
insert into tip_pregleda(ime, cijena, trajanje, sala) values('Analiza krvi',15, 10, 6);



insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (2,1);
insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (3,2);



insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (4,1);
insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (6,2);



insert into pregled (stanje, trajanje, cijena, popust, sala, termin, vrijeme, tip, ljekar_id, tip_pregleda_id, klinika_id) values ('SLOBODAN', 30, 25, 5, 3, '2020-03-8','12:00:00','Redovan pregled', 4,1,2);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, vrijeme, tip, ljekar_id, tip_pregleda_id, klinika_id) values ('SLOBODAN', 10, 15, 5, 9, '2020-03-29','15:00:00','Analiza krvi', 6,2,3);



