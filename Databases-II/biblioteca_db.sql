-- Criando pratica integradora db

DROP DATABASE IF EXISTS pratica3_db;
CREATE DATABASE pratica3_db;
USE pratica3_db;


CREATE TABLE `autores` (
	`id` int(10) unsigned not null auto_increment,
	`nome`varchar(100) not null,
	`nacionalidade` varchar(100) not null,
    PRIMARY KEY (`id`));
    

CREATE TABLE `livros`(
`id` int(10) unsigned not null auto_increment,
`titulo`varchar(100) not null,
`editora` varchar(100) not null,
`area` varchar(50) not null,
PRIMARY KEY (`id`));

CREATE TABLE `alunos`(
`id` int(10) unsigned not null auto_increment,
`nome`varchar(100) not null,
`sobrenome` varchar(100) not null,
`endereco` varchar(50) not null,
`carreira` varchar(50) not null,
`idade` int(10) not null,
PRIMARY KEY (`id`));



CREATE TABLE `livro_autor`(
`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`livro_id` int(10) unsigned not null,
`autor_id`int(10) unsigned not null,
PRIMARY KEY (`id`),
KEY `livro_autor_id_livro_foreign` (`livro_id`),
key `livro_autor_id_autor_foreign` (`autor_id`),
CONSTRAINT `livro_autor_id_livro_foreign` foreign key (`livro_id`) REFERENCES `livros` (`id`),
CONSTRAINT `livro_autor_id_autor_foreign` foreign key (`autor_id`) REFERENCES `autores` (`id`));

CREATE TABLE `emprestimos`(
`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`aluno_id` int(10) unsigned not null,
`livro_id`int(10) unsigned not null,
`data_emprestimo` datetime ,
`data_devolucao` datetime ,
`retornou` boolean not null,
PRIMARY KEY (`id`),
KEY `emprestimos_id_aluno_foreign` (`aluno_id`),
key `emprestimos_id_livro_foreign` (`livro_id`),
CONSTRAINT `emprestimos_id_aluno_foreign` foreign key (`aluno_id`) REFERENCES `alunos` (`id`),
CONSTRAINT `emprestimos_id_livro_foreign` foreign key (`livro_id`) REFERENCES `livros` (`id`));

-- -- LOCK TABLES `funcionarios` WRITE;
INSERT INTO `autores` VALUES 
(1,'Autor1', 'Brasileiro'),(2,'Autor2', 'Argentina'),(3,'J.K. Rowling', 'Francesa'),(4,'Autor4', 'Italiana'),(5,'J.K. Rowling', 'Francesa');

INSERT INTO `alunos` values (1, 'Aluno1','Goncalves', 'Endereco1', 'informatica', 20),(2, 'Aluno2','Garcia', 'Endereco2', 'Carreira 2', 30),
(3, 'Filippo','Galli', 'Endereco3', 'Carreira 3', 40),(4, 'Aluno4','Sobrenome4', 'Endereco4', 'Carreira 4', 50),
(5, 'Aluno5','Sobrenome5', 'Endereco5', 'informatica', 25);

   
INSERT INTO `livros` VALUES (1,'O Universo: Guia de Viagem','Editora1', 'internet'), (2,'Livro2','Editora1', 'Banco de Dado'), (3,'Livro3','salamandra', 'Area1'), 
(4,'Livro4','Editora2', 'internet'), (5,'Livro5','Editora3', 'Banco de Dado');

INSERT INTO `livro_autor` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,1,2);

INSERT INTO `emprestimos` values (1,1,1, '20220331', null, false ),
(2,2,2, '20220331', '20220405', true ),(3,3,3, '20210331', '20210716', false ),(4,4,4, '20220331', '20220404', true ),(5,5,5, '20220331', null, false );