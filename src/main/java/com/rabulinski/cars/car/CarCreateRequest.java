package com.rabulinski.cars.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarCreateRequest {
    private String make;
    private String model;
    private int year;
    // TODO: Infer owner from current session instead
    private UUID ownerId;
}
