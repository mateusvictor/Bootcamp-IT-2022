package br.com.meli.usingdtos.dtos;

import br.com.meli.usingdtos.models.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SportDTO {
    private String name;

    public static SportDTO convert(Sport sport){
        return new SportDTO(sport.getName());
    }
}
