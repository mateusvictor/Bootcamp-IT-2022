package br.meli.movies_db_orm.dto.response;

import br.meli.movies_db_orm.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenreResponseDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private Integer ranking;
    private Boolean active;
    private List<NestedMovieDTO> movies;
}
