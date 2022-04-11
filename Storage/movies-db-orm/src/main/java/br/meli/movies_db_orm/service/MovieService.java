package br.meli.movies_db_orm.service;


import br.meli.movies_db_orm.exception.EntityNotFoundException;
import br.meli.movies_db_orm.model.Movie;
import br.meli.movies_db_orm.repository.ActorRepository;
import br.meli.movies_db_orm.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService implements IService<Movie, Long> {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invalid movie ID: " + id));
    }

    @Override
    @Transactional
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public Movie updateById(Long id, Movie updatedMovie) {
        Movie movie = this.findById(id);

        movie.setCreatedAt(updatedMovie.getCreatedAt());
        movie.setUpdatedAt(updatedMovie.getUpdatedAt());
        movie.setTitle(updatedMovie.getTitle());
        movie.setRating(updatedMovie.getRating());
        movie.setGenre(updatedMovie.getGenre());
        movie.setAwards(updatedMovie.getAwards());
        movie.setReleaseDate(updatedMovie.getReleaseDate());
        movie.setActors(updatedMovie.getActors());
        movie.setLength(updatedMovie.getLength());

        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
