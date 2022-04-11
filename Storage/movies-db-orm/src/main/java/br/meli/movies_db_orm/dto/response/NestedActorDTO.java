package br.meli.movies_db_orm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NestedActorDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;
}
