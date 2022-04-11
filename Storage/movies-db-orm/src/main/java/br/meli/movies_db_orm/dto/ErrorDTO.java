package br.meli.movies_db_orm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDTO {
    private String error;
    private String description;
}
