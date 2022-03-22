package com.meli.carstore.service;

import com.meli.carstore.model.Vehicle;
import com.meli.carstore.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> find(Long id){
        return vehicleRepository.find(id);
    }

    public Vehicle create(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findVehicleByDate(LocalDate since, LocalDate to){
        return findAll().stream()
                .filter(vehicle -> vehicle.getManufacturingDate().isAfter(since) && vehicle.getManufacturingDate().isBefore(to))
                .collect(Collectors.toList());
    }

    public List<Vehicle> findVehicleByPrice(Integer since, Integer to){

        return findAll().stream()
                .filter(vehicle -> Integer.parseInt(vehicle.getPrice()) >= since)
                .filter(vehicle -> Integer.parseInt(vehicle.getPrice()) <= to)
                .collect(Collectors.toList());
    }


}
