package br.meli.movies_db_orm.controller;

import br.meli.movies_db_orm.assembler.GenreAssembler;
import br.meli.movies_db_orm.dto.request.GenreRequestDTO;
import br.meli.movies_db_orm.dto.response.GenreResponseDTO;
import br.meli.movies_db_orm.model.Genre;
import br.meli.movies_db_orm.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/genres")
public class GenreController {
    private final GenreAssembler mapper;
    private final GenreService genreService;

    @GetMapping()
    public ResponseEntity<List<GenreResponseDTO>> getGenres(){
        return ResponseEntity.ok(mapper.toResponseObject(genreService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDTO> getGenre(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toResponseObject(genreService.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<GenreResponseDTO> createGenre(@RequestBody GenreRequestDTO genreDTO, UriComponentsBuilder uriBuilder){
        Genre genre = genreService.create(mapper.toDomainObject(genreDTO));
        URI uri = uriBuilder
                .path("/{id}")
                .buildAndExpand(genre.getId())
                .toUri();
        return ResponseEntity.created(uri).body(mapper.toResponseObject(genre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDTO> updateGenre(@PathVariable Long id, @RequestBody GenreRequestDTO genreUpdated){
        Genre genre = genreService.updateById(id, mapper.toDomainObject(genreUpdated));
        return ResponseEntity.ok(mapper.toResponseObject(genre));
    }
}
