package com.f1.race_simulator.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {

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
}
