package br.com.meli.usingdtos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Sport sport;
}
