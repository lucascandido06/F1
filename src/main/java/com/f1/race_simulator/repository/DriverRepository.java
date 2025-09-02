package com.f1.race_simulator.repository;

import com.f1.race_simulator.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByName(String name);

    Optional<Driver> findByAbbreviation(String abbreviation);

    Optional<Driver> findByNumber(int number);

    List<Driver> findByTeam(Team team);

    List<Driver> findByTeamName(String teamName);

    @Query("SELECT d FROM Driver d WHERE d.skillRating >= :minRating")
    List<Driver> findByMinSkillRating(@Param("minRating") int minRating);

    @Query("SELECT d FROM Driver d ORDER BY d.skillRating DESC")
    List<Driver> findAllOrderBySkillRating();

    @Query("SELECT d FROM Driver d WHERE d.rainSkill >= :minRainSkill")
    List<Driver> findBestRainDrivers(@Param("minRainSkill") int minRainSkill);

    @Query("SELECT d FROM Driver d WHERE d.consistency >= :minConsistency")
    List<Driver> findByMinConsistency(@Param("minConsistency") int minConsistency);
}
