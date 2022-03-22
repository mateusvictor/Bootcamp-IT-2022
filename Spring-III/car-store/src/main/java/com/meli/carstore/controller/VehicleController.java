package com.meli.carstore.controller;

import com.meli.carstore.dto.VehicleCreationDTO;
import com.meli.carstore.dto.VehicleDTO;
import com.meli.carstore.model.Vehicle;
import com.meli.carstore.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/")
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleCreationDTO vehicleCreationDTO){
        System.out.println(vehicleCreationDTO);
        return new ResponseEntity<>(
                VehicleDTO.convert(vehicleService.create(vehicleCreationDTO.convert())),
                HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> getVehicles(){
        return ResponseEntity.ok(VehicleDTO.convert(vehicleService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Long id){
        Optional<Vehicle> vehicle = vehicleService.find(id);

        if (vehicle.isPresent())
            return ResponseEntity.ok(VehicleDTO.convert(vehicle.get()));

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehicleByDate(@RequestParam(name = "since") String since,
                                                             @RequestParam(name = "to") String to){
        return ResponseEntity.ok(
                VehicleDTO.convert(
                        vehicleService.findVehicleByDate(LocalDate.parse(since), LocalDate.parse(to))));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehicleByPrice(@RequestParam(name = "since") Integer since,
                                                             @RequestParam(name = "to") Integer to){
        return ResponseEntity.ok(
                VehicleDTO.convert(
                        vehicleService.findVehicleByPrice(since, to)));
    }
}
