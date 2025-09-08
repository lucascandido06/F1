package com.f1.race_simulator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_drivers")
public class RacingDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String abbreviation;
    private int number;
    private int skillRating; // 1-100
    private int consistency; // 1-100
    private int overtaking; // 1-100 - habilidade de ultrapassagem
    private int defending; // 1-100 - habilidade de defesa
    private int rainSkill; // 1-100 - habilidade na chuva
    private int aggression; // 1-100 - nível de agressividade

    @ManyToOne
    private Team team;

    @ManyToOne
    private Car car;


    public RacingDriver(String name, String abbreviation, int number, int skillRating,
                        int consistency, int overtaking, int defending, int rainSkill,
                        int aggression, Team team, Car car) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.number = number;
        this.skillRating = skillRating;
        this.consistency = consistency;
        this.overtaking = overtaking;
        this.defending = defending;
        this.rainSkill = rainSkill;
        this.aggression = aggression;
        this.team = team;
        this.car = car;
    }
}
