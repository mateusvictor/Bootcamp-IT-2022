package com.meli.carstore.repository;

import com.meli.carstore.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepository {
    private HashMap<Long, Vehicle> vehicles = new HashMap<>();
    private Long lastId  = 0L;

    public Vehicle save(Vehicle vehicle){
        vehicle.setId(lastId + 1);
        lastId += 1;
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }

    public List<Vehicle> findAll(){
        List<Vehicle> vehicleList = new ArrayList<>();
        for (Long key : vehicles.keySet())
            vehicleList.add(vehicles.get(key));
        return vehicleList;
    }

    public Optional<Vehicle> find(Long id){
        return Optional.ofNullable(vehicles.get(id));
    }
}
