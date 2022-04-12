package br.meli.movies_db_orm.controller;

import br.meli.movies_db_orm.assembler.ActorAssembler;
import br.meli.movies_db_orm.dto.request.ActorRequestDTO;
import br.meli.movies_db_orm.dto.response.ActorResponseDTO;
import br.meli.movies_db_orm.model.Actor;
import br.meli.movies_db_orm.repository.ActorRepository;
import br.meli.movies_db_orm.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/actors")
public class ActorController {
    public final ActorService actorService;
    public final ActorAssembler mapper;

    @GetMapping()
    public ResponseEntity<List<ActorResponseDTO>> getActors(){
        return ResponseEntity.ok(mapper.toResponseObject(actorService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorResponseDTO> getActor(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toResponseObject(actorService.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<ActorResponseDTO> createActor(@RequestBody ActorRequestDTO actorDTO, UriComponentsBuilder uriBuilder){
        Actor actor = actorService.create(mapper.toDomainObject(actorDTO));

        URI uri = uriBuilder
                .path("/{id}")
                .buildAndExpand(actor.getId())
                .toUri();

        return ResponseEntity.created(uri).body(mapper.toResponseObject(actor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorResponseDTO> updateActor(@PathVariable Long id, @RequestBody ActorRequestDTO actorUpdated){
        Actor actor = actorService.updateById(id, mapper.toDomainObject(actorUpdated));
        return ResponseEntity.ok(mapper.toResponseObject(actor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ActorResponseDTO> deleteActor(@PathVariable Long id){
        actorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/withFavoriteMovie")
    public ResponseEntity<List<ActorResponseDTO>> getActorsWithFavoriteMovie(){
        return ResponseEntity.ok(mapper.toResponseObject(actorService.findActorsWithFavoriteMovie()));
    }

    @GetMapping("/rating/{minRating}")
    public ResponseEntity<List<ActorResponseDTO>> getActorsByMinRating(@PathVariable Double minRating){
        return ResponseEntity.ok(mapper.toResponseObject(actorService.findActorsByMinRating(minRating)));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ActorResponseDTO>> getActorsByMovieId(@PathVariable Long movieId){
        return ResponseEntity.ok(mapper.toResponseObject(actorService.findActorsByMovieId(movieId)));
    }

}
