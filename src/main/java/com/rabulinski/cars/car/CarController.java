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
    public CarResponse createCar(final CarCreateRequest request) {
        return this.carService.createCar(request);
    }

    @Override
    public CarResponse getCarById(final UUID id) {
        return this.carService.getCarById(id);
    }

    @Override
    public List<CarResponse> getAllCars() {
        return this.carService.getAllCars();
    }

    @Override
    public CarResponse updateCar(final UUID id, final CarCreateRequest request) {
        return this.carService.updateCar(id, request);
    }

    @Override
    public void deleteCar(final UUID id) {
        this.carService.deleteCar(id);
    }
}
