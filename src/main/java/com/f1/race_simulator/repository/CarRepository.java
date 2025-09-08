package com.f1.race_simulator.repository;

import com.f1.race_simulator.model.entity.Car;
import com.f1.race_simulator.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByModel(String model);

    List<Car> findByTeam(Team team);

    List<Car> findByTeamName(String teamName);

    List<Car> findByEngine(String engine);

    @Query("SELECT c FROM Car c WHERE c.powerUnitPerformance >= :minPower")
    List<Car> findByMinPowerUnitPerformance(@Param("minPower") int minPower);

    @Query("SELECT c FROM Car c WHERE c.aerodynamics >= :minAero")
    List<Car> findByMinAerodynamics(@Param("minAero") int minAero);

    @Query("SELECT c FROM Car c ORDER BY (c.powerUnitPerformance + c.aerodynamics + c.chassisEfficiency) DESC")
    List<Car> findAllOrderByOverallPerformance();

    @Query("SELECT c FROM Car c WHERE c.reliability >= :minReliability")
    List<Car> findByMinReliability(@Param("minReliability") int minReliability);

    @Query("SELECT c FROM Car c WHERE c.fuelEfficiency >= :minEfficiency")
    List<Car> findByMinFuelEfficiency(@Param("minEfficiency") int minEfficiency);
}

