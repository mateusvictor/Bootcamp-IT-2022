package com.school.schoolapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Address> addresses;
}
