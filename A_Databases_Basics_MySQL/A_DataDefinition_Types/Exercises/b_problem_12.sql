/* Problem 12 */
CREATE DATABASE `movies`;

CREATE TABLE `directors`
(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);

CREATE TABLE `genres`
(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);

CREATE TABLE `categories`
(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(30) NOT NULL,
`notes` TEXT
);

CREATE TABLE `movies`
(
`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT NOT NULL,
`copyright_year` YEAR NOT NULL,
`length` INT NOT NULL,
`genre_id` INT NOT NULL,
`category_id` INT NOT NULL,
`rating` INT,
`notes` TEXT
);

INSERT INTO directors(director_name)
VALUES ('ASD'),('ASD'),('ASD'),('ASD'),('ASD');

INSERT INTO genres(genre_name)
VALUES ('zxc'),('zxc'),('zxc'),('zxc'),('zxc');

INSERT INTO categories (category_name)
VALUES ('qwe'),('qwe'),('qwe'),('qwe'),('qwe');

INSERT INTO movies (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`)
VALUES
('STAR WARS 1', 1,'1989',135,1,1),
('STAR WARS 2', 2,'1993',135,2,1),
('STAR WARS 3', 3,'1997',130,3,1),
('STAR WARS 4', 4,'2001',130,4,1),
('STAR WARS 5', 5,'2004',130,5,1);
