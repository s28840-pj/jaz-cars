package com.rabulinski.cars.car;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface CarApi {
    @PostMapping("/cars")
    CarResponse createCar(@RequestBody CarCreateRequest request);

    @GetMapping("/cars/{id}")
    CarResponse getCarById(@PathVariable UUID id);

    @GetMapping("/cars")
    List<CarResponse> getAllCars();

    @PutMapping("/cars/{id}")
    CarResponse updateCar(@PathVariable UUID id, @RequestBody CarCreateRequest request);

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable UUID id);
}
