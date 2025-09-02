package com.f1.race_simulator.service;

import com.f1.race_simulator.repository.CarRepository;
import com.f1.race_simulator.repository.CircuitRepository;
import com.f1.race_simulator.repository.DriverRepository;
import com.f1.race_simulator.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataInitializationService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CircuitRepository circuitRepository;
}
