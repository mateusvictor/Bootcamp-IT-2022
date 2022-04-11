package br.meli.movies_db_orm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MovieResponseDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private NestedGenreDTO genre;
    private List<NestedActorDTO> actors;
}
