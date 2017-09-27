CREATE DATABASE `gamebar`;

USE `gamebar`;

CREATE TABLE `employees`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(15) NOT NULL,
`last_name` VARCHAR(15) NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL,
`category_id` INT NOT NULL
);

INSERT INTO employees(first_name,last_name) VALUES('Test1','Test2'), ('Test1','Test2'), ('Test1','Test2');

ALTER TABLE employees
ADD `middle_name` VARCHAR(15) NOT NULL;

ALTER TABLE products
ADD CONSTRAINT `fk_category_id`
FOREIGN KEY(`category_id`)
REFERENCES categories(id)

ALTER TABLE employees
MODIFY COLUMN `middle_name` VARCHAR(100);