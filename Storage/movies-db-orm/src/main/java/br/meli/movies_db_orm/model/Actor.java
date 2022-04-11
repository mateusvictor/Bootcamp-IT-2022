package br.meli.movies_db_orm.model;

import br.meli.movies_db_orm.MoviesDbOrmApplication;
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
@Table(name = "actors")
public class Actor {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}