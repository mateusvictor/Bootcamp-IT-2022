DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE autores (
	`id` int auto_increment not null,
    `nome` varchar(100) not null,
    `nacionalidade` varchar(50) not null,
    PRIMARY KEY (`id`)
);

CREATE TABLE alunos (
	`id` int auto_increment not null,
    `nome` varchar(100) not null,
    `sobrenome` varchar(100) not null,
    `endereco` varchar(200) not null,
    `carreira` varchar(200) not null,
    `idade` int unsigned not null,
    PRIMARY KEY (`id`)
);

CREATE TABLE livros (
	`id` int auto_increment not null,
    `titulo` varchar(50) not null,
    `editora` varchar(50) not null,
    `area` varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE emprestimos (
	`id` int auto_increment not null,
    `leitor_id` int not null,
    `livro_id` int not null,
    `data_emprestimo` DATE not null,
    `data_devolucao` date not null,
    `retornou` bool default false,	
    PRIMARY KEY (`id`),
    KEY `emprestimos_livro_id` (`livro_id`),
    CONSTRAINT `emprestimos_livro_id` FOREIGN KEY (`livro_id`) REFERENCES `livros` (`id`),
    KEY `emprestimo_leitor_id` (`leitor_id`),
    CONSTRAINT `emprestimos_leitor_id` FOREIGN KEY (`leitor_id`) REFERENCES `alunos` (`id`)
);
    

CREATE TABLE livro_autor (
	`id` int auto_increment NOT NULL,
    `livro_id` int NOT NULL,
    `autor_id` int NOT NULL,
    PRIMARY KEY (`id`),
    KEY `livro_autor_livro_id` (`livro_id`),
    CONSTRAINT `livro_autor_livro_id` FOREIGN KEY (`livro_id`) REFERENCES `livros` (`id`),
    KEY `livro_autor_autor_id` (`autor_id`),
    CONSTRAINT `livro_autor_autor_id` FOREIGN KEY (`autor_id`) REFERENCES `autores` (`id`)
);