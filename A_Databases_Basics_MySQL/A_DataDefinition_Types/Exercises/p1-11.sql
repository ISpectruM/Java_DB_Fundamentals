--/* Problem 1.Create database*/
CREATE DATABASE `minions`
USE `minions`;

--/* Problem 2. Create tables*/
CREATE TABLE `minions`(
`id` INT PRIMARY KEY NOT NULL,
`name` VARCHAR(15) NOT NULL,
`age` INT
);

CREATE TABLE `towns`(
`id` INT PRIMARY KEY NOT NULL,
`name` VARCHAR(15) NOT NULL
);

--/*Problem 3*/
ALTER TABLE minions
ADD `town_id` INT;

ALTER TABLE minions
ADD CONSTRAINT `fk_towns_id`
FOREIGN KEY (`town_id`)
REFERENCES  towns(id);

--/*Problem 4*/
INSERT INTO towns(`id`,`name`)
VALUES (1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna');

INSERT INTO minions(`id`,`name`,`age`,`town_id`)
VALUES (1,'Kevin',22,1),
(2,'Bob',15,3),
(3,'Steward',NULL,2);

--/*Problem 5*/
TRUNCATE TABLE minions;

--/*Problem 6*/
DROP TABLE minions;
DROP TABLE towns

--/*Problem 7*/
CREATE TABLE `people`
(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` MEDIUMBLOB,
`height` DOUBLE(10,2),
`weight` DOUBLE(10,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` LONGTEXT
);

INSERT INTO `people`(`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)
VALUES
('Peter',450000,1.2,18.3,'m','2009-02-15','What a biography!'),
('Haralambi',450000,1.8,73.2,'m','2009-02-16','No biography!'),
('Sali',0,1.456,19.3,'f','2009-02-17','What the...!'),
('Mitch',NULL,1.7,20.3,'m','2009-02-18','Fashion consultant till 1999!'),
('Boiko',205,1.8,22.3,'m','2009-02-19','Likes photography and playing piano.')

--/*Problem 8 */
CREATE TABLE `users`
(
`id` BIGINT PRIMARY KEY AUTO_INCREMENT UNIQUE KEY,
`username` CHAR(30) UNIQUE KEY NOT NULL,
`password` CHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIMESTAMP,
`is_deleted` CHAR(5)
);

INSERT INTO users(`username`,`password`,`profile_picture`, `last_login_time`,`is_deleted`)
VALUES
('Salabin','123123',25000,'2017-03-15 12:12:12','false'),
('Galabin','123123',25000,'2017-03-15 12:03:12','true'),
('Balabin','123123',25000,'2017-03-15 12:12:03','false'),
('Palabin','123123',25000,'2017-03-15 03:12:12','true'),
('Lalabin','123123',25000,'2017-03-15 12:03:12','false');

--/* Problem 9 */
ALTER TABLE users
DROP PRIMARY KEY;

ALTER TABLE users
MODIFY id BIGINT NOT NULL;

ALTER TABLE users
ADD CONSTRAINT pk_id PRIMARY KEY(id,username);

--/* Problem 10 */
ALTER TABLE users
ALTER COLUMN last_login_time DROP DEFAULT;

ALTER TABLE users
MODIFY COLUMN last_login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

--/* Problem 11 */
ALTER TABLE users
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`),
ADD CONSTRAINT uc_username UNIQUE (`username`);
