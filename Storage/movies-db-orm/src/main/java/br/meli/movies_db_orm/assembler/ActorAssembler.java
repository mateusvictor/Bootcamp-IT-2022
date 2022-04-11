package br.meli.movies_db_orm.assembler;

import br.meli.movies_db_orm.dto.request.ActorRequestDTO;
import br.meli.movies_db_orm.dto.request.GenreRequestDTO;
import br.meli.movies_db_orm.dto.response.ActorResponseDTO;
import br.meli.movies_db_orm.dto.response.GenreResponseDTO;
import br.meli.movies_db_orm.model.Actor;
import br.meli.movies_db_orm.model.Genre;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ActorAssembler {
    private final ModelMapper modelMapper;

    public Actor toDomainObject(ActorRequestDTO actorRequestDTO){
        return modelMapper.map(actorRequestDTO, Actor.class);
    }
    public ActorResponseDTO toResponseObject(Actor actor){
        return modelMapper.map(actor, ActorResponseDTO.class);
    }

    public List<ActorResponseDTO> toResponseObject(List<Actor> actorList){
        return actorList.stream()
                .map(this::toResponseObject)
                .collect(Collectors.toList());
    }
}



