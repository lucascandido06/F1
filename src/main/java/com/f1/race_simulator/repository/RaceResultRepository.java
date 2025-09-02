package com.f1.race_simulator.repository;

import com.f1.race_simulator.model.entity.RaceEvent;
import com.f1.race_simulator.model.entity.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {

    List<RaceResult> findByDriver(Driver driver);

    List<RaceResult> findByRaceEvent(RaceEvent raceEvent);

    List<RaceResult> findByDriverAndRaceEvent(Driver driver, RaceEvent raceEvent);

    Optional<RaceResult> findByRaceEventAndPosition(RaceEvent raceEvent, int position);

    @Query("SELECT rr FROM RaceResult rr WHERE rr.raceEvent.id = :raceEventId ORDER BY rr.position ASC")
    List<RaceResult> findByRaceEventIdOrderByPosition(@Param("raceEventId") Long raceEventId);

    @Query("SELECT rr FROM RaceResult rr WHERE rr.raceEvent.id = :raceEventId AND rr.position <= :maxPosition")
    List<RaceResult> findByRaceEventIdAndTopPositions(@Param("raceEventId") Long raceEventId, @Param("maxPosition") int maxPosition);

    @Query("SELECT rr FROM RaceResult rr WHERE rr.raceEvent.id = :raceEventId AND rr.finished = true")
    List<RaceResult> findFinishersByRaceEventId(@Param("raceEventId") Long raceEventId);

    @Query("SELECT rr FROM RaceResult rr WHERE rr.raceEvent.id = :raceEventId AND rr.finished = false")
    List<RaceResult> findDnfByRaceEventId(@Param("raceEventId") Long raceEventId);

    @Query("SELECT rr FROM RaceResult rr WHERE rr.raceEvent.id = :raceEventId AND rr.fastestLap = true")
    Optional<RaceResult> findFastestLapByRaceEventId(@Param("raceEventId") Long raceEventId);

    @Query("SELECT rr FROM RaceResult rr WHERE rr.driver.id = :driverId AND rr.position = 1")
    List<RaceResult> findWinsByDriverId(@Param("driverId") Long driverId);

    @Query("SELECT rr FROM RaceResult rr WHERE rr.driver.team.id = :teamId AND rr.position = 1")
    List<RaceResult> findWinsByTeamId(@Param("teamId") Long teamId);

    @Query("SELECT COUNT(rr) FROM RaceResult rr WHERE rr.driver.id = :driverId AND rr.position BETWEEN 1 AND 3")
    Long countPodiumsByDriverId(@Param("driverId") Long driverId);

    @Query("SELECT AVG(rr.position) FROM RaceResult rr WHERE rr.driver.id = :driverId AND rr.finished = true")
    Optional<Double> findAveragePositionByDriverId(@Param("driverId") Long driverId);

    @Query("SELECT rr FROM RaceResult rr WHERE rr.raceEvent.id = :raceEventId AND rr.pitStops = (SELECT MIN(rr2.pitStops) FROM RaceResult rr2 WHERE rr2.raceEvent.id = :raceEventId)")
    List<RaceResult> findLeastPitStopsByRaceEventId(@Param("raceEventId") Long raceEventId);
}
