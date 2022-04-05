-- 1. Mostrar o título e o nome do gênero de todas as séries.
SELECT series.title, genres.name AS genre FROM series
	INNER JOIN genres
    ON series.genre_id = genres.id;

-- 2. Mostrar o título dos episódios, o nome e sobrenome dos atores que trabalham em cada um deles.
SELECT actors.first_name, episodes.title FROM actors
	INNER JOIN actor_episode
    ON actors.id = actor_episode.actor_id
    INNER JOIN episodes
    ON episodes.id = actor_episode.episode_id;
    
-- 3. Mostrar o título de todas as séries e o número total de temporadas que cada uma delas possui.--
SELECT series.title, COUNT(*) AS number_of_seasons FROM series 
	INNER JOIN seasons
    ON seasons.serie_id = series.id
    GROUP BY series.title;
    
-- 4. Mostrar o nome de todos os gêneros e o número total de filmes de cada um, desde que seja maior ou igual a 3.
SELECT genres.name AS genre, COUNT(*) as number_of_movies FROM genres
	INNER JOIN movies
    ON genres.id = movies.genre_id
    GROUP BY genres.name
    HAVING number_of_movies >= 3;
    
-- 5. Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de Star Wars e que estes não se repitam.-- 
SELECT DISTINCT actors.first_name, actors.last_name FROM actors
	INNER JOIN actor_movie
    ON actors.id = actor_movie.actor_id
    INNER JOIN movies
    ON actor_movie.movie_id = movies.id
    WHERE movies.title LIKE 'La Guerra de las galaxias%';

