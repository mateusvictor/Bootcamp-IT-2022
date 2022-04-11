package br.meli.movies_db_orm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NestedGenreDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private Integer ranking;
    private Boolean active;
}
