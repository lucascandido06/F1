package com.f1.race_simulator.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "race_results")
public class RaceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Position is required")
    @PositiveOrZero(message = "Position must be zero or positive")
    @Column(nullable = false)
    private Integer position;

    @Column(name = "grid_position")
    private Integer gridPosition;

    @Column(name = "total_time")
    private Double totalTime; // tempo total da corrida em segundos

    @Column(name = "points_earned")
    private Double pointsEarned = 0.0;

    @Column(name = "pit_stops")
    private Integer pitStops = 0;

    @Column(name = "fastest_lap")
    private Boolean fastestLap = false;

    @Column(name = "finished")
    private Boolean finished = true;

    @Column(name = "status", length = 50)
    private String status; // FINISHED, DNF, DSQ, etc.

    @Column(name = "laps_completed")
    private Integer lapsCompleted;

    @Column(name = "best_lap_time")
    private Double bestLapTime;

    @Column(name = "average_lap_time")
    private Double averageLapTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private RacingDriver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_event_id", nullable = false)
    private RaceEvent raceEvent;
}
