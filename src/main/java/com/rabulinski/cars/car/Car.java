package com.rabulinski.cars.car;

import com.rabulinski.cars.owner.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String make;
    private String model;
    @Column(name = "modelYear")
    private int year;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
    private boolean verified;
}

