package br.meli.movies_db_orm.repository;

import br.meli.movies_db_orm.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovieId is not NULL")
    List<Actor> findActorsWithFavoriteMovie();

    @Query("SELECT a FROM Actor a WHERE a.rating > :minRating")
    List<Actor> findActorByMinRating(@Param("minRating") Double minRating);

//    @Query("SELECT a FROM Actor a INNER JOIN actor_movie ON a.id = actor_movie.actor_id INNER JOIN Movies m ON actor_movie.movie_id = m.id WHERE movies.id = :movieId")
    @Query("SELECT m.actors FROM Movie m WHERE m.id = :movieId")
    List<Actor> findActorByMovieId(@Param("movieId") Long movieId);
}
