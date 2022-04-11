package br.meli.movies_db_orm.dto.request;

import br.meli.movies_db_orm.dto.response.NestedActorDTO;
import br.meli.movies_db_orm.dto.response.NestedGenreDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieRequestDTO {
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @NotBlank(message = "title field must not be null.")
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;

    @NotNull(message = "length field must not be null.")
    private Integer length;
    @NotNull(message = "genreId field must not be null.")
    private Long genreId;
    @NotEmpty(message = "actorsIds field must not be empty.")
    private List<Long> actorsIds;
}


