package com.f1.race_simulator.repository;

import com.f1.race_simulator.model.entity.LapTime;
import com.f1.race_simulator.model.entity.RaceEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

@Repository
public interface LapTimeRepository extends JpaRepository<LapTime, Long> {

    List<LapTime> findByDriver(Driver driver);

    List<LapTime> findByRaceEvent(RaceEvent raceEvent);

    List<LapTime> findByDriverAndRaceEvent(Driver driver, RaceEvent raceEvent);

    @Query("SELECT lt FROM LapTime lt WHERE lt.raceEvent.id = :raceEventId ORDER BY lt.time ASC")
    List<LapTime> findByRaceEventIdOrderByTimeAsc(@Param("raceEventId") Long raceEventId);

    @Query("SELECT lt FROM LapTime lt WHERE lt.driver.id = :driverId ORDER BY lt.time ASC")
    List<LapTime> findByDriverIdOrderByTimeAsc(@Param("driverId") Long driverId);

    @Query("SELECT lt FROM LapTime lt WHERE lt.raceEvent.id = :raceEventId AND lt.position = 1")
    Optional<LapTime> findWinnerByRaceEventId(@Param("raceEventId") Long raceEventId);

    @Query("SELECT lt FROM LapTime lt WHERE lt.raceEvent.id = :raceEventId AND lt.driver.team.name = :teamName")
    List<LapTime> findByRaceEventIdAndTeamName(@Param("raceEventId") Long raceEventId, @Param("teamName") String teamName);

    @Query("SELECT MIN(lt.time) FROM LapTime lt WHERE lt.raceEvent.id = :raceEventId")
    Optional<Double> findFastestLapTimeByRaceEventId(@Param("raceEventId") Long raceEventId);

    @Query("SELECT lt FROM LapTime lt WHERE lt.raceEvent.id = :raceEventId AND lt.time = (SELECT MIN(lt2.time) FROM LapTime lt2 WHERE lt2.raceEvent.id = :raceEventId)")
    Optional<LapTime> findFastestLapByRaceEventId(@Param("raceEventId") Long raceEventId);

    @Query("SELECT AVG(lt.time) FROM LapTime lt WHERE lt.raceEvent.id = :raceEventId")
    Optional<Double> findAverageLapTimeByRaceEventId(@Param("raceEventId") Long raceEventId);
}
