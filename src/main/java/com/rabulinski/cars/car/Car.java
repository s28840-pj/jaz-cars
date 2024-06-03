package com.rabulinski.cars.car;

import com.rabulinski.cars.owner.Owner;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @NotEmpty
    private String make;
    @NotNull
    @NotEmpty
    private String model;
    @Column(name = "modelYear")
    private int year;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @NotNull
    private Owner owner;
    private boolean verified;
}

