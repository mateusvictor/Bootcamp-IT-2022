package com.school.schoolapi.model;

import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String country;
    private String state;
    private String street;
    private Long number;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
