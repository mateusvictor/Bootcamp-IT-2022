package com.meli.carstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public Vehicle(String brand, String model, LocalDate manufacturingDate, String numberOfKilometers,
                   String doors, String price, String currency, List<Service> services, String countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", numberOfKilometers='" + numberOfKilometers + '\'' +
                ", doors='" + doors + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", services=" + services +
                ", countOfOwners='" + countOfOwners + '\'' +
                '}';
    }
}
