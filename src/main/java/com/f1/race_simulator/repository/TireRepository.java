package com.f1.race_simulator.repository;

import com.f1.race_simulator.model.entity.Tire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TireRepository extends JpaRepository<Tire,Long> {

    Optional<Tire> findByCompound(String compound);

    List<Tire> findByDurabilityGreaterThanEqual(int minDurability);

    List<Tire> findByGripGreaterThanEqual(int minGrip);

    List<Tire> findByDegradationRateLessThanEqual(int maxDegradation);

    @Query("SELECT t FROM Tire t WHERE t.compound IN :compounds")
    List<Tire> findByCompounds(@Param("compounds") List<String> compounds);

    @Query("SELECT t FROM Tire t ORDER BY t.grip DESC")
    List<Tire> findAllOrderByGrip();

    @Query("SELECT t FROM Tire t ORDER BY t.durability DESC")
    List<Tire> findAllOrderByDurability();

    @Query("SELECT t FROM Tire t WHERE t.grip >= :minGrip AND t.durability >= :minDurability")
    List<Tire> findByMinGripAndDurability(@Param("minGrip") int minGrip, @Param("minDurability") int minDurability);
}
