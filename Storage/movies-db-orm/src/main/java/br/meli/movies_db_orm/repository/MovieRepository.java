package br.meli.movies_db_orm.repository;

import br.meli.movies_db_orm.model.Actor;
import br.meli.movies_db_orm.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
//    @Query("SELECT m FROM Movie m JOIN actor_movie ON m.id = actor_movie.movie_id")
//    @Query(value = "SELECT movies.id FROM movies " +
//            "INNER JOIN actor_movie ON movies.id = actor_movie.movie_id " +
//            "INNER JOIN actors ON actor_movie.actor_id = actors.id " +
//            "WHERE actors.rating > :minRating ", nativeQuery = true)
//    @Query("SELECT m FROM Movie m JOIN Actor a WHERE a.rating > :minRating")
//    List<Long> findMoviesByActorsRating(@Param("minRating") Double minRating);

    @Query("SELECT g.movies FROM Genre g WHERE g.id = :genreId")
    List<Movie> findMoviesByGenreId(@Param("genreId") Long id);
}
