USE movies_db;
SET SQL_SAFE_UPDATES = 0;
-- 1. Adicione um filme à tabela de filmes.
INSERT INTO movies VALUES (null, null, null,'Vingadores', 8.1, 12, '2000-09-17', 200, null);

-- 2. Adicione um gênero à tabela de gêneros.
INSERT INTO genres VALUES (null, '2000-09-17', null, 'Acao', 13, 1);

-- 3. Associe o filme do ponto 1. com o gênero criado no ponto 2.
UPDATE movies SET genre_id = (SELECT id FROM genres WHERE name = 'Acao')
	WHERE title = 'Vingadores';

-- 4. Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado no ponto 1 como favorito.
UPDATE actors SET favorite_movie_id = 129 WHERE first_name = 'Bryan' AND last_name = 'Cranston';

-- 5. Crie uma tabela temporária da tabela filmes.
CREATE TEMPORARY TABLE movies_temp 
	SELECT * FROM movies;
    
-- 6. Elimine dessa tabela temporária todos os filmes que ganharam menos de 5 prêmios.
DELETE FROM movies_temp WHERE awards < 5;

-- 7. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
SELECT genres.id, genres.name, count(*) as movies FROM genres 
	INNER JOIN movies ON genres.id = movies.genre_id
    GROUP BY genres.id
    HAVING movies >= 1;

-- 8. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
SELECT actors.first_name, actors.last_name, movies.awards FROM actors 
	INNER JOIN movies ON actors.favorite_movie_id = movies.id
    WHERE awards > 3;
    
-- 9. Crie um índice no nome na tabela de filmes.
CREATE INDEX movies_name_idx ON movies (title);

-- 10. Verifique se o índice foi criado corretamente.
SHOW INDEX FROM movies;

-- 11. No banco de dados movies, haveria uma melhoria notável na criação de índices? Analise e justifique a resposta.
-- R: 

-- 12. Em que outra tabela você criaria um índice e por quê? Justifique a resposta
-- R.: Criaria um índice na tabela "actors" para a coluna "awards", visto que a mesma foi amplamente utilizada nas queries sugeridas.