CREATE TABLE `towns`
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL
);

CREATE TABLE `addresses`
(
id INT PRIMARY KEY AUTO_INCREMENT,
address_text VARCHAR(50) NOT NULL,
town_id INT NOT NULL,
CONSTRAINT `fk_town_id` FOREIGN KEY(`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `departments`
(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20) NOT NULL
);

CREATE TABLE `employees`
(
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	middle_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	job_title VARCHAR(20) NOT NULL,
	department_id INT NOT NULL,
	hire_date DATE NOT NULL,
	salary DOUBLE NOT NULL,
	address_id INT NOT NULL,
	CONSTRAINT `fk_department` FOREIGN KEY(department_id) REFERENCES `departments`(`id`),
	CONSTRAINT `fk_address` FOREIGN KEY(`address_id`) REFERENCES `addresses`(`id`)
);