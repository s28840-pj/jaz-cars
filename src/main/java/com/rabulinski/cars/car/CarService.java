package com.rabulinski.cars.car;

import com.rabulinski.cars.owner.Owner;
import com.rabulinski.cars.owner.OwnerNotFoundException;
import com.rabulinski.cars.owner.OwnerRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    public CarResponse createCar(@NotNull @Valid final CarCreateRequest request) {
        final UUID ownerId = request.getOwnerId();
        final Owner owner = this.ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(ownerId));
        Car car = this.mapper.toEntity(request, owner);
        car = this.carRepository.save(car);
        return this.mapper.toResponse(car);
    }

    @Transactional
    public CarResponse getCarById(@NotNull final UUID id) {
        final Car car = this.carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        return this.mapper.toResponse(car);
    }

    @Transactional
    public List<CarResponse> getAllCars() {
        return this.carRepository.findAll().stream().map(this.mapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public CarResponse updateCar(@NotNull final UUID id, @NotNull @Valid final CarCreateRequest request) {
        Car car = this.carRepository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        final Owner owner = Optional.ofNullable(request.getOwnerId()).map(ownerId -> this.ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(ownerId))).orElse(car.getOwner());
        car = this.mapper.update(car, request, owner);
        return this.mapper.toResponse(car);
    }

    @Transactional
    public void deleteCar(@NotNull final UUID id) {
        this.carRepository.deleteById(id);
    }
}