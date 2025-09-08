package com.f1.race_simulator.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_circuits")
public class Circuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Circuit name is required")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Country is required")
    @Column(nullable = false)
    private String country;

    @NotNull(message = "Lap length is required")
    @Positive(message = "Lap length must be positive")
    @Column(name = "lap_length", nullable = false)
    private Double lapLength; // em km

    @NotNull(message = "Number of laps is required")
    @Positive(message = "Number of laps must be positive")
    @Column(nullable = false)
    private Integer laps;

    @NotNull(message = "Lap record is required")
    @Positive(message = "Lap record must be positive")
    @Column(name = "lap_record", nullable = false)
    private Double lapRecord; // tempo do recorde em segundos

    @NotNull(message = "Dry lap variation is required")
    @Positive(message = "Dry lap variation must be positive")
    @Column(name = "dry_lap_variation", nullable = false)
    private Double dryLapVariation; // variação de tempo em condições secas

    @NotNull(message = "Wet lap variation is required")
    @Positive(message = "Wet lap variation must be positive")
    @Column(name = "wet_lap_variation", nullable = false)
    private Double wetLapVariation; // variação de tempo em condições de chuva

    @Column(name = "overtaking_difficulty")
    private Integer overtakingDifficulty; // 1-100 (facilidade de ultrapassagem)

    @Column(name = "tyre_degradation")
    private Integer tyreDegradation; // 1-100 (taxa de degradação de pneus)

    public Circuit(String name, String country, Double lapLength, Integer laps,
                   Double lapRecord, Double dryLapVariation, Double wetLapVariation,
                   Integer overtakingDifficulty, Integer tyreDegradation) {
        this.name = name;
        this.country = country;
        this.lapLength = lapLength;
        this.laps = laps;
        this.lapRecord = lapRecord;
        this.dryLapVariation = dryLapVariation;
        this.wetLapVariation = wetLapVariation;
        this.overtakingDifficulty = overtakingDifficulty;
        this.tyreDegradation = tyreDegradation;
    }

    public Circuit(String name, String country, Double lapLength, Integer laps,
                   Double lapRecord, Double dryLapVariation, Double wetLapVariation) {
        this.name = name;
        this.country = country;
        this.lapLength = lapLength;
        this.laps = laps;
        this.lapRecord = lapRecord;
        this.dryLapVariation = dryLapVariation;
        this.wetLapVariation = wetLapVariation;
    }
}
