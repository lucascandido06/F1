package com.f1.race_simulator.repository;

import com.f1.race_simulator.model.entity.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Long> {

    Optional<Circuit> findByName(String name);

    List<Circuit> findByCountry(String country);

    @Query("SELECT c FROM Circuit c ORDER BY c.lapRecord ASC")
    List<Circuit> findAllOrderByLapRecord();

    @Query("SELECT c FROM Circuit c WHERE c.lapLength BETWEEN :minLength AND :maxLength")
    List<Circuit> findByLapLengthBetween(double minLength, double maxLength);

}
