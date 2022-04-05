DROP DATABASE IF EXISTS company_db;
CREATE DATABASE company_db;
USE company_db;

CREATE TABLE departments (
    `id` INT AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `location` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE employees (
    `id` INT auto_increment,
    `first_name` VARCHAR(60) NOT NULL,
    `last_name` VARCHAR(60) NOT NULL,
    `job` VARCHAR(50) NOT NULL,
    `entry_date` DATE NOT NULL,
    `salary` DECIMAL(9, 2) NOT NULL,
    `bonus` DECIMAL(9, 2) NOT NULL,
    `department_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `employees_department_id_foreign` (`department_id`),
    CONSTRAINT `employees_department_id_foreign` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB;

INSERT INTO departments VALUES 
    (1, 'Software', 'Los Tigres'),
    (2, 'Sistemas', 'Guadalupe'),
    (3, 'Contabilidade', 'La Roca'),
    (4, 'Vendas', 'Plata');
    
INSERT INTO employees VALUES 
    (1, 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000.00, 15000.00, 4),
    (2, 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000.00, 0.00, 2),
    (3, 'Mariela', 'Barrios', 'Diretor', '2014-06-05', 185000.00, 0.00, 3),
    (4, 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000.00, 10000.00, 4),
    (5, 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000.00, 10000.00, 4),
    (6, 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000.00, 0.00, 3),
    (7, 'Emilio', 'Galarza', 'Desenvolvedor', '2014-08-02', 60000.00, 0.00, 1);