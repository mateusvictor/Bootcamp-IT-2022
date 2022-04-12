package br.meli.movies_db_orm.controller;

import br.meli.movies_db_orm.assembler.MovieAssembler;
import br.meli.movies_db_orm.dto.request.MovieRequestDTO;
import br.meli.movies_db_orm.dto.response.MovieResponseDTO;
import br.meli.movies_db_orm.exception.EntityNotFoundException;
import br.meli.movies_db_orm.model.Actor;
import br.meli.movies_db_orm.model.Genre;
import br.meli.movies_db_orm.model.Movie;
import br.meli.movies_db_orm.repository.ActorRepository;
import br.meli.movies_db_orm.repository.GenreRepository;
import br.meli.movies_db_orm.service.ActorService;
import br.meli.movies_db_orm.service.GenreService;
import br.meli.movies_db_orm.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/movies")
public class MovieController {
    private final MovieService movieService;
    private final ActorService actorService;
    private final GenreService genreService;
    private final MovieAssembler mapper;

    @GetMapping()
    public ResponseEntity<List<MovieResponseDTO>> getMovies(){
        return ResponseEntity.ok(mapper.toResponseObject(movieService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toResponseObject(movieService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> deleteMovie(@PathVariable Long id){
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<MovieResponseDTO> createMovie(@Valid @RequestBody MovieRequestDTO movieDTO, UriComponentsBuilder uriBuilder){
        Movie movie = requestDTOToMovie(movieDTO);
        MovieResponseDTO movieResponseDTO = mapper.toResponseObject(movieService.create(movie));

        URI uri = uriBuilder
                .path("/{id}")
                .buildAndExpand(movieResponseDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(movieResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> updateMovie(@PathVariable Long id, @Valid @RequestBody MovieRequestDTO movieDTO){
        Movie updatedMovie = requestDTOToMovie(movieDTO);
        MovieResponseDTO movieResponseDTO = mapper.toResponseObject(movieService.updateById(id, updatedMovie));
        return ResponseEntity.ok(movieResponseDTO);
    }

    private Movie requestDTOToMovie(MovieRequestDTO movieDTO) {
        Movie movie = mapper.toDomainObject(movieDTO);
        List<Actor> actorList = new ArrayList<>();

        Genre genre = genreService.findById(movieDTO.getGenreId());
        
        for (Long id : movieDTO.getActorsIds())
            actorList.add(actorService.findById(id));

        movie.setActors(actorList);
        movie.setGenre(genre);
        return movie;
    }
}
