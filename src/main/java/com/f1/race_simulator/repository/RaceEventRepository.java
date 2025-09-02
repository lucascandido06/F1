package com.f1.race_simulator.repository;

import com.f1.race_simulator.model.entity.Circuit;
import com.f1.race_simulator.model.entity.RaceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RaceEventRepository extends JpaRepository<RaceEvent, Long> {

    Optional<RaceEvent> findByName(String name);

    List<RaceEvent> findByCircuit(Circuit circuit);

    List<RaceEvent> findByCircuitName(String circuitName);

    List<RaceEvent> findByEventType(RaceEvent.EventType eventType);

    List<RaceEvent> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<RaceEvent> findByDateAfter(LocalDate date);

    List<RaceEvent> findByDateBefore(LocalDate date);

    @Query("SELECT re FROM RaceEvent re WHERE re.round = :round")
    Optional<RaceEvent> findByRound(@Param("round") int round);

    @Query("SELECT re FROM RaceEvent re ORDER BY re.round ASC")
    List<RaceEvent> findAllOrderByRound();

    @Query("SELECT re FROM RaceEvent re WHERE re.weather = :weatherCondition")
    List<RaceEvent> findByWeatherCondition(@Param("weatherCondition") RaceEvent.WeatherCondition weatherCondition);

    @Query("SELECT re FROM RaceEvent re WHERE re.safetyCarDeployed = true")
    List<RaceEvent> findEventsWithSafetyCar();

    @Query("SELECT re FROM RaceEvent re WHERE re.safetyCarDeployments > 0")
    List<RaceEvent> findEventsWithSafetyCarDeployments();
}
