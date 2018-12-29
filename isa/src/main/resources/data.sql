insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (1, "Pera", "Peric", "asds@gmail.com", "pass", "novi asd", "0213231", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (2, "Mika", "Peric", "asds@gmail.com", "pass", "novi asd", "0213231", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (3, "Zika", "Peric", "asds@gmail.com", "pass", "novi asd", "0213231", false); 
insert into user(id,name,surname,email,password,address,phone_nmbr,verified) values (4, "Pare", "Peric", "asds@gmail.com", "pass", "novi asd", "0213231", false);

insert into hotel(id,name,address,description,image) values (1, "Palisad", "Zlatibor", "Lep hotel", "../../assets/img/palisad.jpg");
insert into hotel(id,name,address,description,image) values (2, "Park", "Novi Sad", "Sajmiste", "../../assets/img/park.jpg");  
insert into hotel(id,name,address,description,image) values (3, "Putnik", "Novi Sad", "U centru", "../../assets/img/putnik.jpg");  
  
insert into room(id, beds, price, hotel_id) values (1, 2, 40, 1);
insert into room(id, beds, price, hotel_id) values (2, 3, 54, 1);
insert into room(id, beds, price, hotel_id) values (3, 4, 67, 1);

insert into airline(id, name, address, description, image) values (1, "Air Srbija", "Beograd", "Serbian airline", "../../assets/img/airserbia.jpg");
insert into destinations(airline_id, destinations) values (1, "London");
insert into destinations(airline_id, destinations) values (1, "Madrid");
insert into destinations(airline_id, destinations) values (1, "Berlin");
insert into airline(id, name, address, description, image) values (2, "Emirates", "Dubai", "UAE", "../../assets/img/emirates.png");
insert into destinations(airline_id, destinations) values (2, "Berlin");
insert into destinations(airline_id, destinations) values (2, "New York");
insert into destinations(airline_id, destinations) values (2, "Moscow");
insert into destinations(airline_id, destinations) values (2, "Nis");

insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price) values (1, "Beograd", "London", "2018-12-22", "12:00", "2018-12-22", "16:00", 670, 1, 300);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price) values (2, "Beograd", "Madrid", "2018-12-23", "12:00", "2018-12-23", "16:00", 1790, 1, 800);
insert into flight(id, departure_place, destination, take_off_date, take_off_time, land_date, land_time, distance, airline_id, price) values (3, "Dubai", "New York", "2018-12-22", "12:00", "2018-12-23", "16:00", 7090, 2, 1480);
insert into stops(flight_id, stops) values (3, "Paris");
insert into stops(flight_id, stops) values (3, "Lisabon");

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
