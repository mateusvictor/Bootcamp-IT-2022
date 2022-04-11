package br.meli.movies_db_orm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenreRequestDTO {
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @NotBlank(message = "name field must not be null.")
    private String name;
    private Integer ranking;
    @NotBlank(message = "active field must not be null.")
    private Boolean active;
}

