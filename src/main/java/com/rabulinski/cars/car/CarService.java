package com.rabulinski.cars.car;

import com.rabulinski.cars.owner.Owner;
import com.rabulinski.cars.owner.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;
    private OwnerRepository ownerRepository;

    public CarResponse createCar(CarCreateRequest request) {
        Owner owner = ownerRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        Car car = new Car();
        car.setMake(request.getMake());
        car.setModel(request.getModel());
        car.setYear(request.getYear());
        car.setOwner(owner);
        car = carRepository.save(car);
        return mapToCarResponse(car);
    }

    public CarResponse getCarById(UUID id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        return mapToCarResponse(car);
    }

    public List<CarResponse> getAllCars() {
        return carRepository.findAll().stream()
                .map(this::mapToCarResponse)
                .collect(Collectors.toList());
    }

    public CarResponse updateCar(UUID id, CarCreateRequest request) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        Owner owner = ownerRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        car.setMake(request.getMake());
        car.setModel(request.getModel());
        car.setYear(request.getYear());
        car.setOwner(owner);
        car = carRepository.save(car);
        return mapToCarResponse(car);
    }

    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }

    private CarResponse mapToCarResponse(Car car) {
        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setMake(car.getMake());
        response.setModel(car.getModel());
        response.setYear(car.getYear());
        response.setOwnerName(car.getOwner().getName());
        return response;
    }
}