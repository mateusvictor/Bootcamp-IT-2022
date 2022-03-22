package com.meli.carstore.dto;

import com.meli.carstore.model.Service;
import com.meli.carstore.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VehicleDTO {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;


    public static VehicleDTO convert(Vehicle vehicle) {
        if (vehicle == null)
            return null;

        return new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(),
                vehicle.getCurrency(), vehicle.getCountOfOwners());
    }

    public static List<VehicleDTO> convert(List<Vehicle> vehicles){
        if (vehicles == null)
            return null;
        return vehicles.stream()
                .map(vehicle -> VehicleDTO.convert(vehicle))
                .collect(Collectors.toList());
    }
}