package br.meli.movies_db_orm.dto.response;

import br.meli.movies_db_orm.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorResponseDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;
    private List<NestedMovieDTO> movies;
}
