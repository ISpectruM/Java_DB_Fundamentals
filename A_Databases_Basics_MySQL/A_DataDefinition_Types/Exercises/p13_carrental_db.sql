/* Problem 13 */
CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories`
(
id INT PRIMARY KEY AUTO_INCREMENT,
category VARCHAR(30) NOT NULL,
daily_rate DOUBLE NOT NULL,
weekly_rate DOUBLE NOT NULL,
monthly_rate DOUBLE NOT NULL,
weekend_rate DOUBLE NOT NULL
);

CREATE TABLE `cars`
(
id INT PRIMARY KEY AUTO_INCREMENT,
plate_number CHAR(10) NOT NULL,
make VARCHAR(30) NOT NULL,
model VARCHAR(30) NOT NULL,
car_year YEAR NOT NULL,
category_id INT NOT NULL,
doors INT NOT NULL,
picture BLOB,
car_condition VARCHAR(10) NOT NULL,
available CHAR(10) NOT NULL
);

CREATE TABLE `employees`
(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
title VARCHAR(20) NOT NULL,
notes TEXT
);

CREATE TABLE `customers`
(
id INT PRIMARY KEY AUTO_INCREMENT,
driver_licence_number INT NOT NULL,
full_name VARCHAR(20) NOT NULL,
address VARCHAR(50) NOT NULL,
city VARCHAR(15) NOT NULL,
zip_code VARCHAR(10) NOT NULL,
notes TEXT
);

CREATE TABLE `rental_orders`
(
id INT PRIMARY KEY AUTO_INCREMENT,
employee_id INT NOT NULL,
customer_id INT NOT NULL,
car_id INT NOT NULL,
car_condition VARCHAR(10) NOT NULL,
tank_level DOUBLE NOT NULL,
kilometrage_start DOUBLE NOT NULL,
kilometrage_end DOUBLE,
total_kilometrage DOUBLE,
start_date DATE NOT NULL,
end_date DATE,
total_days INT,
rate_applied CHAR(10) NOT NULL,
tax_rate DOUBLE NOT NULL,
order_status VARCHAR(20) NOT NULL,
notes TEXT
);

INSERT INTO categories(category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
VALUES ('VAN',12.5,120.2,500,20.8),('VAN',12.5,120.2,500,20.8),('VAN',12.5,120.2,500,20.8);

INSERT INTO cars(plate_number, make, model, car_year, category_id, doors, picture, car_condition, available)
VALUES ('AC4545LK','JAPAN','SELICA','1998',1,4,250,'USED','AVAILABLE'),
('AC4545LK','JAPAN','SELICA','1998',1,4,250,'USED','AVAILABLE'),
('AC4545LK','JAPAN','SELICA','1998',1,4,250,'USED','AVAILABLE');

INSERT INTO employees(first_name, last_name, title)
VALUES ('SANI','PETROHANOV','MANAGER'),
('SANI','PETROHANOV','MANAGER'),
('SANI','PETROHANOV','MANAGER');

INSERT INTO customers(driver_licence_number, full_name, address, city, zip_code)
VALUES (654456,'JJ','ASDASD','AD','65465-123'),
(654456,'JJ','ASDASD','AD','65465-123'),
(654456,'JJ','ASDASD','AD','65465-123');

INSERT INTO rental_orders(employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status)
VALUES
(1,2,3,'USED',2.5,45654.2,9879.5,456.5,'1978-12-08','2017-12-08',4000,'DAYLY',2.5,'NOT FINISHED'),
(1,2,3,'USED',2.5,45654.2,9879.5,456.5,'1978-12-08','2017-12-08',4000,'DAYLY',2.5,'NOT FINISHED'),
(1,2,3,'USED',2.5,45654.2,9879.5,456.5,'1978-12-08','2017-12-08',4000,'DAYLY',2.5,'NOT FINISHED');