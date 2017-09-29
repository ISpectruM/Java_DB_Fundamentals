CREATE TABLE `employees`
(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name CHAR(15) NOT NULL,
last_name CHAR(15) NOT NULL,
title VARCHAR(20) NOT NULL,
notes TEXT
);

CREATE TABLE `customers`
(
account_number VARCHAR(50) PRIMARY KEY,
first_name VARCHAR(15) NOT NULL,
last_name VARCHAR(15) NOT NULL,
phone_number VARCHAR(30) NOT NULL,
emergency_name VARCHAR(30) NOT NULL,
emergency_number VARCHAR(30) NOT NULL,
notes TEXT
);

CREATE TABLE `room_status`
(
room_status VARCHAR(15) PRIMARY KEY,
notes TEXT
);

CREATE TABLE `room_types`
(
room_type VARCHAR(20) PRIMARY KEY,
notes TEXT
);

CREATE TABLE `bed_types`
(
bed_type VARCHAR(20) PRIMARY KEY,
notes TEXT
);

CREATE TABLE `rooms`
(
room_number INT PRIMARY KEY,
room_type VARCHAR(20) NOT NULL,
bed_type VARCHAR(20) NOT NULL,
rate VARCHAR(20) NOT NULL,
room_status VARCHAR(20) NOT NULL,
notes TEXT
);

CREATE TABLE `payments`
(
id INT PRIMARY KEY AUTO_INCREMENT,
employee_id INT NOT NULL,
payment_date DATE NOT NULL,
account_number VARCHAR(50) NOT NULL,
first_date_occupied DATE NOT NULL,
last_date_occupied DATE NOT NULL,
total_days INT NOT NULL,
amount_charged DOUBLE NOT NULL,
tax_rate DOUBLE NOT NULL,
tax_amount DOUBLE NOT NULL,
payment_total DOUBLE NOT NULL,
notes TEXT
);

CREATE TABLE `occupancies`
(
id INT PRIMARY KEY AUTO_INCREMENT,
employee_id INT NOT NULL,
date_occupied DATE NOT NULL,
account_number VARCHAR(50) NOT NULL,
room_number INT NOT NULL,
rate_applied DOUBLE NOT NULL,
phone_charge DOUBLE NOT NULL,
notes TEXT
);

INSERT INTO employees (first_name, last_name, title)
VALUES ('QWE','QWEQWE','QWEEWQ'), ('QWE','QWEQWE','QWEEWQ'),('QWE','QWEQWE','QWEEWQ');

INSERT INTO customers
(account_number, first_name, last_name, phone_number, emergency_name, emergency_number)
VALUES ('7894','ASD','ASDASD','+654','ASDAS','+654654'),
('4256','ASD','ASDASD','+654','ASDAS','+654654'),
('1232','ASD','ASDASD','+654','ASDAS','+654654');

INSERT INTO room_status (room_status)
VALUES ('QWE'),('DFASDG'),('ZXC');

INSERT INTO room_types (room_type)
VALUES ('DFG'),('FGH'),('GHJ');

INSERT INTO bed_types (bed_type)
VALUES ('QWE'),('ASD'),('ZXC');

INSERT INTO rooms (room_number, room_type, bed_type, rate, room_status)
VALUES (123,'DFG','DFG',1.2,'DFG'),(12,'DFG','DFG',1.2,'DFG'),(23,'DFG','DFG',1.2,'DFG');

INSERT INTO payments
(employee_id, payment_date, account_number, first_date_occupied, last_date_occupied, total_days, amount_charged, tax_rate, tax_amount, payment_total)
VALUES (1,'2017-12-12','654654','2017-12-12','2017-12-12',23,23.5,1.5,12,456),
(1,'2017-12-12','654654','2017-12-12','2017-12-12',23,23.5,1.5,12,456),
(1,'2017-12-12','654654','2017-12-12','2017-12-12',23,23.5,1.5,12,456);

INSERT INTO occupancies
(employee_id, date_occupied, account_number, room_number, rate_applied, phone_charge)
VALUES (2,'2017-02-02','456456',12,1.5,12.5),
(2,'2017-02-02','456456',12,1.5,12.5),
(2,'2017-02-02','456456',12,1.5,12.5);