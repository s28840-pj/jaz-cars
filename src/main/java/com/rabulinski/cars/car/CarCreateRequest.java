package com.rabulinski.cars.car;

import lombok.*;

import java.util.UUID;

@Data
public class CarCreateRequest {
    private String make;
    private String model;
    private int year;
    // TODO: Infer owner from current session instead
    private UUID ownerId;
}
