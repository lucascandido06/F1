package com.f1.race_simulator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int performanceRating; // 1-100
    private double pitStopAvg; // tempo médio de pitstop em segundos
    private double pitStopVariation; // variação no tempo de pitstop
    private int strategyRating; // 1-100 - qualidade das estratégias

    @OneToMany(mappedBy = "team")
    private List<Car> cars;

    @OneToMany(mappedBy = "team")
    private List<Driver> drivers;
}
