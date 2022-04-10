package br.meli.tutorials.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tutorials")
public class Tutorial {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String title;
    private String description;
    private Boolean published;
}
