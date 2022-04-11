package br.meli.movies_db_orm.assembler;

import br.meli.movies_db_orm.dto.request.GenreRequestDTO;
import br.meli.movies_db_orm.dto.response.GenreResponseDTO;
import br.meli.movies_db_orm.model.Genre;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class GenreAssembler {
    private final ModelMapper modelMapper;

    public Genre toDomainObject(GenreRequestDTO genreRequestDTO){
        return modelMapper.map(genreRequestDTO, Genre.class);
    }
    public GenreResponseDTO toResponseObject(Genre genre){
        return modelMapper.map(genre, GenreResponseDTO.class);
    }

    public List<GenreResponseDTO> toResponseObject(List<Genre> genreList){
        return genreList.stream()
                .map(this::toResponseObject)
                .collect(Collectors.toList());
    }
}
