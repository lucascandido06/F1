package com.f1.race_simulator.repository;

import com.f1.race_simulator.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByName(String name);

    @Query("SELECT t FROM Team t WHERE t.performanceRating >= :minRating")
    List<Team> findByMinPerformanceRating(@Param("minRating") int minRating);

    @Query("SELECT t FROM Team t ORDER BY t.performanceRating DESC")
    List<Team> findAllOrderByPerformanceRating();

    @Query("SELECT t FROM Team t WHERE t.strategyRating >= :minStrategyRating")
    List<Team> findByMinStrategyRating(@Param("minStrategyRating") int minStrategyRating);

    @Query("SELECT t FROM Team t WHERE t.pitStopAvg <= :maxPitStopTime")
    List<Team> findByPitStopTimeLessThan(@Param("maxPitStopTime") double maxPitStopTime);
}
