#NOT FINISHED !

CREATE TABLE `towns` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(60) NOT NULL
);

INSERT INTO `towns` (`name`)
VALUES ('Sofia'),
       ('Plovdiv'),
       ('Varna'),
       ('Burgas');
       
CREATE TABLE `addresses` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `addresses_text` VARCHAR(120),
    `town_id` INT
);

ALTER TABLE `addresses`
ADD CONSTRAINT `fk_adresses_townId_towns_id`
FOREIGN KEY (`town_id`) 
REFERENCES `towns` (`id`);

CREATE TABLE `departments` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

INSERT INTO `departments` (`name`)
VALUES ('Engineering'),
       ('Sales'),
       ('Marketing'),
       ('Software Development'),
       ('Quality Assurance');
       
CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `middle_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL,
    `job_title` VARCHAR(60) NOT NULL,
    `department_id` INT NOT NULL,
    `hire_date` DATE NOT NULL,
    `salary` DOUBLE(10, 2) NOT NULL,
    `adress_id` INT
);

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
	   ('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
       ('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
       ('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
       ('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);
