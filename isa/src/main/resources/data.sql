insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (1, "Veljko", "Petrovic", "vpetrovic@gmail.com", "pass", "Novi Sad", "021323221", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (2, "Stefan", "Stefanovic", "stefans@gmail.com", "pass", "Beocin", "021521151", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (3, "Branko", "Markovic", "brankomarkovic@gmail.com", "pass", "Beograd", "021236235", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (4, "Mila", "Lukic", "milamila@gmail.com", "pass", "Subotica", "021325312", false);
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (5, "Stanislava", "Loncar", "stanislaval@gmail.com", "pass", "Pancevo", "021534231", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (6, "Milan", "Vujosevic", "milanvuj123@gmail.com", "pass", "Titel", "021732331", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (7, "Ana", "Vlahovic", "anavlahovic99@gmail.com", "pass", "Novi Sad", "021632231", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (8, "Pavle", "Jankovic", "pavlej233@gmail.com", "pass", "Becej", "021532321", false);


INSERT INTO friendship(confirm,status,receiver_id,sender_id) VALUES ('?',0,1,2);
INSERT INTO friendship(confirm,status,receiver_id,sender_id) VALUES ('?',1,1,3);
INSERT INTO friendship(confirm,status,receiver_id,sender_id) VALUES ('?',1,2,3);
INSERT INTO friendship(confirm,status,receiver_id,sender_id) VALUES ('?',1,1,4);
INSERT INTO friendship(confirm,status,receiver_id,sender_id) VALUES ('?',1,2,6);
INSERT INTO friendship(confirm,status,receiver_id,sender_id) VALUES ('?',0,1,7);
INSERT INTO friendship(confirm,status,receiver_id,sender_id) VALUES ('?',0,1,6);
INSERT INTO friendship(confirm,status,receiver_id,sender_id) VALUES ('?',2,1,5);


insert into hotel(id,name,address,description,image) values (1, "Palisad", "Zlatibor", "Lep hotel", "../../assets/img/palisad.jpg");
insert into hotel(id,name,address,description,image) values (2, "Park", "Novosadskog sajma 35 Novi Sad", "Sajmiste", "../../assets/img/park.jpg");  
insert into hotel(id,name,address,description,image) values (3, "Putnik", "Ilije Ognjanovica 24 Novi Sad", "U centru", "../../assets/img/putnik.jpg");  
  
insert into room(id, beds, price, hotel_id) values (1, 2, 40, 1);
insert into room(id, beds, price, hotel_id) values (2, 3, 54, 1);
insert into room(id, beds, price, hotel_id) values (3, 4, 67, 1);

insert into airline(id, name, address, description, image) values (1, "Air Srbija", "Beograd", "Serbian airline", "../../assets/img/airserbia.jpg");
insert into destination(airline_id, name) values (1, "Beocin");
insert into destination(airline_id, name) values (1, "Madrid");
insert into destination(airline_id, name) values (1, "Berlin");
insert into airline(id, name, address, description, image) values (2, "Emirates", "Dubai", "UAE", "../../assets/img/emirates.png");
insert into destination(airline_id, name) values (2, "Berlin");
insert into destination(airline_id, name) values (2, "New York");
insert into destination(airline_id, name) values (2, "Moscow");
insert into destination(airline_id, name) values (2, "Nis");

insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price) values (1, "Beograd", "London", "2018-12-22", "12:00", "2018-12-22", "16:00", 670, 1, 300);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price) values (2, "Beograd", "Madrid", "2018-12-23", "12:00", "2018-12-23", "16:00", 1790, 1, 800);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price) values (3, "Dubai", "New York", "2018-12-22", "12:00", "2018-12-23", "16:00", 7090, 2, 1480);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price) values (4, "Beograd", "Madrid", "2018-12-23", "12:00", "2018-12-23", "16:00", 1200, 2, 1200);

insert into stop(name, flight_id) values ("Paris", 3);
insert into stop(name, flight_id) values ("Lisabon", 3);

insert into rentacar(id, name, address, description, image) values (1, "Star", "Novi Sad", "Best prices", "../../assets/img/star.png");
insert into rentacar(id, name, address, description, image) values (2, "Control", "Beograd", "Best cars", "../../assets/img/control.jpg");
insert into vehicle(id, manufacturer, model, production_year, seats, type, price, rentacar_id) values (1, "Mercedes-Benz", "S-Class", 2016, 4, 3, 190, 2);
insert into vehicle(id, manufacturer, model, production_year, seats, type, price, rentacar_id) values (2, "Audi", "A3", 2017, 5, 0, 90, 2);
insert into vehicle(id, manufacturer, model, production_year, seats, type, price, rentacar_id) values (3, "Skoda", "Octavia", 2014, 5, 1, 70, 1);
insert into branch_office(id, address, head_office_id) values (1, "Maksima Gorkog 32", 1);
insert into branch_office(id, address, head_office_id) values (2, "Bulevar oslobodjenja 126", 1);
insert into branch_office(id, address, head_office_id) values (3, "Hajduk Veljkova 7", 2);

insert into pricelist(id, hotel_id) values (1, 1);
insert into pricelist(id, hotel_id) values (2, 2);
insert into pricelist(id, hotel_id) values (3, 3);


insert into additional_service(id, name, price, pricelist_id) values (1, 'Wifi', 10, 1);
insert into additional_service(id, name, price, pricelist_id) values (2, 'Wifi', 13, 2);
insert into additional_service(id, name, price, pricelist_id) values (3, 'Wifi', 12, 3);
insert into additional_service(id, name, price, pricelist_id) values (4, 'Breakfast', 7, 1);
insert into additional_service(id, name, price, pricelist_id) values (5, 'Air condition', 5, 1);
insert into additional_service(id, name, price, pricelist_id) values (6, 'Parking', 11, 1);
