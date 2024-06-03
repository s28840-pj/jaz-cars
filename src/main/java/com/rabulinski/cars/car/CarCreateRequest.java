package com.rabulinski.cars.car;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CarCreateRequest {
    @NotNull
    @NotEmpty
    private String make;
    @NotNull
    @NotEmpty
    private String model;
    private int year;
    // TODO: Infer owner from current session instead
    @NotNull
    private UUID ownerId;
}
