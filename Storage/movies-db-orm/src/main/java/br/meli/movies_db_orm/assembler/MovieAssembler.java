package br.meli.movies_db_orm.assembler;

import br.meli.movies_db_orm.dto.request.MovieRequestDTO;
import br.meli.movies_db_orm.dto.response.MovieResponseDTO;
import br.meli.movies_db_orm.model.Movie;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MovieAssembler{

    private final ModelMapper modelMapper;

    public Movie toDomainObject(MovieRequestDTO movieRequestDTO) {
        return modelMapper.map(movieRequestDTO, Movie.class);
    }

    public MovieResponseDTO toResponseObject(Movie movie) {
        return modelMapper.map(movie, MovieResponseDTO.class);
    }

    public List<MovieResponseDTO> toResponseObject(List<Movie> movieList){
        return movieList.stream()
                .map(this::toResponseObject)
                .collect(Collectors.toList());
    }
}