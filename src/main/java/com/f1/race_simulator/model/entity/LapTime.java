package com.f1.race_simulator.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lap_times")
public class LapTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Lap time is required")
    @Positive(message = "Lap time must be positive")
    @Column(nullable = false)
    private Double time; // tempo em segundos

    @Column(name = "lap_number")
    private Integer lapNumber;

    @Column(name = "position")
    private Integer position;

    @Column(name = "is_fastest_lap")
    private Boolean isFastestLap = false;

    @Column(name = "tyre_compound")
    private String tyreCompound;

    @Column(name = "lap_sector1")
    private Double sector1Time;

    @Column(name = "lap_sector2")
    private Double sector2Time;

    @Column(name = "lap_sector3")
    private Double sector3Time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_event_id", nullable = false)
    private RaceEvent raceEvent;
}
