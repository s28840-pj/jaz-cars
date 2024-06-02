package com.rabulinski.cars.owner;

import com.rabulinski.cars.car.Car;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;
}
