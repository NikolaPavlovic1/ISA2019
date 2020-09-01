INSERT INTO address (id, city, country, latitude, longitude,number,street, version)
VALUES (101, "Novi Sad", "Serbia", 40, 40, 60, "Papa Pavla", 0);

INSERT INTO address (id, city, country, latitude, longitude,number,street, version)
VALUES (102, "Novi Sad", "Serbia", 30, 30, 1, "Bolnicka", 0);

INSERT INTO address (id, city, country, latitude, longitude,number,street, version)
VALUES (103, "Novi Sad", "Serbia", 30, 31, 133, "Prvomajska", 0);

INSERT INTO address (id, city, country, latitude, longitude,number,street, version)
VALUES (104, "Novi Sad", "Serbia", 32, 31, 34, "Neznanih junaka", 0);

INSERT INTO address (id, city, country, latitude, longitude,number,street, version)
VALUES (105, "Novi Sad", "Serbia", 70, 31, 1, "Cara Dusana", 0);

INSERT INTO address (id, city, country, latitude, longitude,number,street, version)
VALUES (106, "Novi Sad", "Serbia", 72, 32, 11, "Cara Lazara", 0);

INSERT INTO address (id, city, country, latitude, longitude,number,street, version)
VALUES (107, "Novi Sad", "Serbia", 22, 10, 5, "Bul. Mihajla Pupina", 0);

INSERT INTO address (id, city, country, latitude, longitude,number,street, version)
VALUES (108, "Novi Sad", "Serbia", 22, 10, 5, "Bul. Oslobodenja Test", 0);


INSERT INTO clinic (id, description, name, address_id, version)
VALUES (101, "Gradska bolnica Novi Sad", "Nova gradska bolnica", 102, 0);

INSERT INTO clinic (id, description, name, address_id, version)
VALUES (102, "Klinicki centar u Novom Sadu", "Klinicki centar Vojvodine", 105, 0);


INSERT INTO user (id, active, approved, confirmation_key, email,insurance_number,last_name,
	name, password, phone_number, role, username, address_id, clinic_id, declined, version)
VALUES (101, 1, 1, 'OE8VWPORPSVON8QS9D',"izs.fidzi@gmail.com", "15sa2", "Pavlovic",
"Nikola", '$2a$10$BjNIEnkw0fXiOBA6vlATb.ksRGwr1PYOsmdxGjkBK6IQfYiP0OPGa', "0637557096", 1, "admin",101,null,0,0);

INSERT INTO user (id, active, approved, confirmation_key, email,insurance_number,last_name,
	name, password, phone_number, role, username, address_id, clinic_id, declined, version)
VALUES (102, 1, 1, 'DWX6WDH7VTF1QXXJJ8',"nikolare@sbb.rs", "1561", "Rebic",
"Nikola", '$2a$10$ggfs7Qv9bAQFPFzFgWw2GOeKkBRjyvfAgP6CD5vYvcyTdHMdDNGjK', "064565565", 2, "Reba",103,101,0,0);


INSERT INTO user (id, active, approved, confirmation_key, email,insurance_number,last_name,
	name, password, phone_number, role, username, address_id, clinic_id, declined, version)
VALUES (103, 1, 1, 'QWPAY8TBSD07966U9Y',"nikola.pavlovic.e38@gmail.com", "1561658", "Lakovic",
"Jovan", '$2a$10$FodAvmfwD0j2O152UxAY4uYvzmI7fMKtiqGBPppXWDbnYkHBJwtWi', "062526564", 0, "Jole",104,null,0,0);

INSERT INTO user (id, active, approved, confirmation_key, email,insurance_number,last_name,
	name, password, phone_number, role, username, address_id, clinic_id, declined, version)
VALUES (104, 1, 1, 'DWX6WDH7VTF1QXXJKK',"jasmina231067@gmail.com", "1561", "Marko",
"Kopanja", '$2a$10$FodAvmfwD0j2O152UxAY4uYvzmI7fMKtiqGBPppXWDbnYkHBJwtWi', "06222222", 2, "Kopanja",106,101,0,0);

INSERT INTO user (id, active, approved, confirmation_key, email,insurance_number,last_name,
	name, password, phone_number, role, username, address_id, clinic_id, declined, version)
VALUES (105, 1, 1, 'DWX6WDH7VTF1QXXJKK',"nepostojeci@gmail.com", "1561", "Stefan",
"Bajic", '$2a$10$FodAvmfwD0j2O152UxAY4uYvzmI7fMKtiqGBPppXWDbnYkHBJwtWi', "06222222", 2, "Bajic",107,102,0,0);


INSERT INTO medical_record(id, user, version) VALUES (101, 101, 0);
INSERT INTO medical_record(id, user, version) VALUES (102, 102, 0);
INSERT INTO medical_record(id, user, version) VALUES (103, 103, 0);
INSERT INTO medical_record(id, user, version) VALUES (104, 104, 0);
INSERT INTO medical_record(id, user, version) VALUES (105, 105, 0);



INSERT INTO disease(id, name, version) VALUES (101, "Koronavirus", 0);

INSERT INTO disease_medical_records(disease_history_id, medical_records_id) VALUES (101, 103);

INSERT INTO medical_room(id, description, clinic_id, version) VALUES (101, "Medical room 1A", 101, 0);
INSERT INTO medical_room(id, description, clinic_id, version) VALUES (102, "Medical room 1B", 101, 0);
INSERT INTO medical_room(id, description, clinic_id, version) VALUES (103, "Medical room 1", 102, 0);

INSERT INTO type_duration(id, duration, type, version) VALUES (101, 40, "Eye examination", 0);
INSERT INTO type_duration(id, duration, type, version) VALUES (102, 120, "COVID-19 examination", 0);
INSERT INTO type_duration(id, duration, type, version) VALUES (103, 35, "Dental examination", 0);
INSERT INTO type_duration(id, duration, type, version) VALUES (104, 800, "MRI", 0);

INSERT INTO type_duration_doctors(types_of_examination_id,doctors_id) VALUES (102, 102);
INSERT INTO type_duration_doctors(types_of_examination_id,doctors_id) VALUES (103, 102);
INSERT INTO type_duration_doctors(types_of_examination_id,doctors_id) VALUES (101, 104);
INSERT INTO type_duration_doctors(types_of_examination_id,doctors_id) VALUES (104, 105);
INSERT INTO type_duration_doctors(types_of_examination_id,doctors_id) VALUES (101, 105);
INSERT INTO type_duration_doctors(types_of_examination_id,doctors_id) VALUES (102, 105);

INSERT INTO pricelist_item(id, price, type_of_examination,clinic_id, version) 
VALUES (101, 500, "COVID-19 examination", 101, 0);

INSERT INTO pricelist_item(id, price, type_of_examination,clinic_id, version) 
VALUES (102, 1500, "Dental examination", 101, 0);

INSERT INTO pricelist_item(id, price, type_of_examination,clinic_id, version) 
VALUES (103, 2500, "Eye examination", 101, 0);

INSERT INTO pricelist_item(id, price, type_of_examination,clinic_id, version) 
VALUES (104, 3500, "MRI", 102, 0);

INSERT INTO pricelist_item(id, price, type_of_examination,clinic_id, version) 
VALUES (105, 4500, "Eye examination", 102, 0);

INSERT INTO pricelist_item(id, price, type_of_examination,clinic_id, version) 
VALUES (106, 5500, "Dental examination", 102, 0);


INSERT INTO medical_examination(id, price, start_date_time,doctor_id, medical_record_id, medical_room_id,
type_and_duration_id,  version) 
VALUES (101, 500, "2020-01-01 19:00:00", 102, 103, 101, 102, 0);

INSERT INTO medical_examination(id, price, start_date_time,doctor_id, medical_record_id, medical_room_id,
type_and_duration_id,  version) 
VALUES (103, 500, "2020-01-03 19:00:00", 102, 103, 101, 102, 0);

INSERT INTO medical_examination(id, price, start_date_time,doctor_id, medical_record_id, medical_room_id,
type_and_duration_id,  version) 
VALUES (104, 500, "2020-11-11 19:00:00", 102, 103, 101, 102, 0);


INSERT INTO medical_examination(id, price, start_date_time,doctor_id, medical_record_id, medical_room_id,
type_and_duration_id,  version) 
VALUES (102, 500, "2020-12-12 19:00:00", 102, null, 101, 102, 0);


INSERT INTO medical_examination(id, price, start_date_time,doctor_id, medical_record_id, medical_room_id,
type_and_duration_id,  version) 
VALUES (105, 9500, "2020-12-12 19:00:00", 102, null, 101, 102, 0);



