CREATE TABLE `mountains`(
id INT PRIMARY KEY NOT NULL,
name VARCHAR(30) NOT NULL
);

CREATE TABLE `peaks`(
	id INT PRIMARY KEY NOT NULL,
	name VARCHAR(30) NOT NULL,
	mountain_id INT NOT NULL,
	CONSTRAINT `fk_mountain_id` FOREIGN KEY(mountain_id) REFERENCES `mountains`(id)
);