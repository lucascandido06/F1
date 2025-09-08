package com.f1.race_simulator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String engine;

    // Características de performance
    private int powerUnitPerformance; // 1-100
    private int aerodynamics; // 1-100
    private int chassisEfficiency; // 1-100
    private int reliability; // 1-100
    private int fuelEfficiency; // 1-100

    @ManyToOne
    private Team team;


    public Car(String model, String engine, int powerUnitPerformance, int aerodynamics,
               int chassisEfficiency, int reliability, int fuelEfficiency, Team team) {
        this.model = model;
        this.engine = engine;
        this.powerUnitPerformance = powerUnitPerformance;
        this.aerodynamics = aerodynamics;
        this.chassisEfficiency = chassisEfficiency;
        this.reliability = reliability;
        this.fuelEfficiency = fuelEfficiency;
        this.team = team;
    }
}
