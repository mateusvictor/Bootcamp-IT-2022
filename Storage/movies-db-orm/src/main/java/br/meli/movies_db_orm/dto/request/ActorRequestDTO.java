package br.meli.movies_db_orm.dto.request;

import br.meli.movies_db_orm.dto.response.NestedMovieDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorRequestDTO {
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;
}
