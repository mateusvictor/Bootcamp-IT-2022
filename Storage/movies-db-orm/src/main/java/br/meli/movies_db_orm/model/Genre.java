package br.meli.movies_db_orm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "genres")
public class Genre {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private Integer ranking;
    private Boolean active;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "genre")
    private List<Movie> movies;
}
