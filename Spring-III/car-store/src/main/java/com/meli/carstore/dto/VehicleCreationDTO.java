package com.meli.carstore.dto;

import com.meli.carstore.model.Service;
import com.meli.carstore.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VehicleCreationDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public Vehicle convert(){
        return new Vehicle(brand, model, manufacturingDate, numberOfKilometers, doors, price, currency, services, countOfOwners);
    }

    @Override
    public String toString() {
        return "VehicleCreationDTO{" +
                "brand='" + brand + '\'' +
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
