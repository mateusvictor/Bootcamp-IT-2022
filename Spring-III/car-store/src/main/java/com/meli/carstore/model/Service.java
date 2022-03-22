package com.meli.carstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Service {
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
