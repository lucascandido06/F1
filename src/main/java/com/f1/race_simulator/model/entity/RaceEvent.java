package com.f1.race_simulator.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "race_events")
public class RaceEvent {

    public enum EventType {
        TL1, TL2, TL3, QUALIFYING, SPRINT, RACE
    }

    public enum WeatherCondition {
        SUNNY, CLOUDY, LIGHT_RAIN, HEAVY_RAIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Event name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Round number is required")
    @Column(nullable = false, unique = true)
    private Integer round;

    @NotNull(message = "Event date is required")
    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circuit_id", nullable = false)
    private Circuit circuit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WeatherCondition weather;

    @Column(name = "safety_car_deployed")
    private Boolean safetyCarDeployed = false;

    @Column(name = "safety_car_deployments")
    private Integer safetyCarDeployments = 0;

    @Column(name = "red_flag")
    private Boolean redFlag = false;

    @Column(name = "track_temperature")
    private Double trackTemperature; // em °C

    @Column(name = "air_temperature")
    private Double airTemperature; // em °C

    @OneToMany(mappedBy = "raceEvent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LapTime> lapTimes = new ArrayList<>();

    @OneToMany(mappedBy = "raceEvent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RaceResult> raceResults = new ArrayList<>();
}
