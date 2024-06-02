package com.rabulinski.cars.car;

import lombok.*;

import java.util.UUID;

@Data
public class CarResponse {
    private UUID id;
    private String make;
    private String model;
    private int year;
    private String ownerName;
}
