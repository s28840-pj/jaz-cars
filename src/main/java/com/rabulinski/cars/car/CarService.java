package com.rabulinski.cars.car;

import com.rabulinski.cars.owner.Owner;
import com.rabulinski.cars.owner.OwnerNotFoundException;
import com.rabulinski.cars.owner.OwnerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final CarMapper mapper;

    @Transactional
    public CarResponse createCar(CarCreateRequest request) {
        UUID ownerId = request.getOwnerId();
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(ownerId));
        Car car = mapper.toEntity(request, owner);
        car = carRepository.save(car);
        return mapper.toResponse(car);
    }

    @Transactional
    public CarResponse getCarById(UUID id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        return mapper.toResponse(car);
    }

    @Transactional
    public List<CarResponse> getAllCars() {
        return carRepository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public CarResponse updateCar(UUID id, CarCreateRequest request) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        Owner owner = Optional.ofNullable(request.getOwnerId()).map(ownerId -> ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(ownerId))).orElse(car.getOwner());
        car = mapper.update(car, request, owner);
        return mapper.toResponse(car);
    }

    @Transactional
    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }
}