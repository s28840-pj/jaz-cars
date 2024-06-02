package com.rabulinski.cars.car;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CarController implements CarApi {
    private CarService carService;

    @Override
    public CarResponse createCar(CarCreateRequest request) {
        return carService.createCar(request);
    }

    @Override
    public CarResponse getCarById(UUID id) {
        return carService.getCarById(id);
    }

    @Override
    public List<CarResponse> getAllCars() {
        return carService.getAllCars();
    }

    @Override
    public CarResponse updateCar(UUID id, CarCreateRequest request) {
        return carService.updateCar(id, request);
    }

    @Override
    public void deleteCar(UUID id) {
        carService.deleteCar(id);
    }
}
