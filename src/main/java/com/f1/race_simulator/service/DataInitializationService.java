package com.f1.race_simulator.service;

import com.f1.race_simulator.model.entity.Car;
import com.f1.race_simulator.model.entity.RacingDriver;
import com.f1.race_simulator.model.entity.Team;
import com.f1.race_simulator.repository.TeamRepository;
import com.f1.race_simulator.model.entity.*;
import com.f1.race_simulator.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

    @Autowired
    private TireRepository tireRepository;


    @PostConstruct
    public void init() {
        initTeamsAndDrivers();
        initCircuits();
    }

    private void initTeamsAndDrivers() {
        // Red Bull Racing
        Team redBull = new Team("Red Bull Racing", 95, 2.1, 0.2, 90);
        teamRepository.save(redBull);

        Car rb21 = new Car("RB21", "Honda RBPT", 96, 97, 94, 88, 90, redBull);
        carRepository.save(rb21);

        RacingDriver verstappen = new RacingDriver("Max Verstappen", "VER", 1, 98, 95, 96, 94, 97, 92, redBull, rb21);
        RacingDriver lawson = new RacingDriver("Liam Lawson", "LAW", 40, 82, 85, 80, 78, 80, 75, redBull, rb21);
        driverRepository.save(verstappen);
        driverRepository.save(lawson);

        // Mercedes
        Team mercedes = new Team("Mercedes-AMG Petronas F1 Team", 92, 2.2, 0.15, 92);
        teamRepository.save(mercedes);

        Car mercedesCar = new Car("Mercedes-AMG F1 W16", "Mercedes", 94, 93, 95, 92, 91, mercedes);
        carRepository.save(mercedesCar);

        RacingDriver russell = new RacingDriver("George Russell", "RUS", 63, 90, 88, 89, 87, 85, 84, mercedes, mercedesCar);
        RacingDriver antonelli = new RacingDriver("Andrea Kimi Antonelli", "ANT", 47, 85, 82, 84, 80, 82, 78, mercedes, mercedesCar);
        driverRepository.save(russell);
        driverRepository.save(antonelli);

        // Scuderia Ferrari
        Team ferrari = new Team("Scuderia Ferrari", 94, 2.3, 0.25, 88);
        teamRepository.save(ferrari);

        Car sf25 = new Car("SF-25", "Ferrari", 95, 95, 93, 90, 89, ferrari);
        carRepository.save(sf25);

        RacingDriver leclerc = new RacingDriver("Charles Leclerc", "LEC", 16, 94, 90, 92, 91, 88, 86, ferrari, sf25);
        RacingDriver hamilton = new RacingDriver("Lewis Hamilton", "HAM", 44, 96, 97, 95, 96, 90, 85, ferrari, sf25);
        driverRepository.save(leclerc);
        driverRepository.save(hamilton);

        // McLaren F1 Team
        Team mclaren = new Team("McLaren F1 Team", 90, 2.4, 0.3, 87);
        teamRepository.save(mclaren);

        Car mcl39 = new Car("MCL39", "Mercedes", 91, 94, 91, 87, 92, mclaren);
        carRepository.save(mcl39);

        RacingDriver norris = new RacingDriver("Lando Norris", "NOR", 4, 93, 91, 93, 89, 86, 82, mclaren, mcl39);
        RacingDriver piastri = new RacingDriver("Oscar Piastri", "PIA", 81, 89, 88, 87, 85, 84, 80, mclaren, mcl39);
        driverRepository.save(norris);
        driverRepository.save(piastri);

        // Aston Martin Aramco F1 Team
        Team astonMartin = new Team("Aston Martin Aramco F1 Team", 87, 2.5, 0.35, 85);
        teamRepository.save(astonMartin);

        Car amr25 = new Car("AMR25", "Mercedes", 88, 89, 88, 85, 87, astonMartin);
        carRepository.save(amr25);

        RacingDriver alonso = new RacingDriver("Fernando Alonso", "ALO", 14, 92, 96, 90, 95, 89, 88, astonMartin, amr25);
        RacingDriver stroll = new RacingDriver("Lance Stroll", "STR", 18, 84, 80, 82, 79, 78, 75, astonMartin, amr25);
        driverRepository.save(alonso);
        driverRepository.save(stroll);

        // BWT Alpine F1 Team
        Team alpine = new Team("BWT Alpine F1 Team", 82, 2.6, 0.4, 80);
        teamRepository.save(alpine);

        Car a525 = new Car("A525", "Renault", 83, 84, 82, 80, 83, alpine);
        carRepository.save(a525);

        RacingDriver gasly = new RacingDriver("Pierre Gasly", "GAS", 10, 87, 85, 86, 84, 83, 81, alpine, a525);
        RacingDriver doohan = new RacingDriver("Jack Doohan", "DOO", 61, 79, 78, 77, 76, 75, 74, alpine, a525);
        driverRepository.save(gasly);
        driverRepository.save(doohan);

        // Williams Racing
        Team williams = new Team("Williams Racing", 80, 2.7, 0.45, 78);
        teamRepository.save(williams);

        Car fw47 = new Car("FW47", "Mercedes", 81, 82, 80, 78, 81, williams);
        carRepository.save(fw47);

        RacingDriver albon = new RacingDriver("Alexander Albon", "ALB", 23, 88, 86, 85, 87, 82, 79, williams, fw47);
        RacingDriver sainz = new RacingDriver("Carlos Sainz", "SAI", 55, 91, 89, 88, 90, 85, 83, williams, fw47);
        driverRepository.save(albon);
        driverRepository.save(sainz);

        // Visa Cash App RB Formula One Team
        Team vcarb = new Team("Visa Cash App RB Formula One Team", 84, 2.4, 0.3, 82);
        teamRepository.save(vcarb);

        Car vcarb02 = new Car("VCARB 02", "Honda RBPT", 85, 86, 84, 82, 85, vcarb);
        carRepository.save(vcarb02);

        RacingDriver tsunoda = new RacingDriver("Yuki Tsunoda", "TSU", 22, 86, 84, 85, 83, 82, 80, vcarb, vcarb02);
        RacingDriver hadjar = new RacingDriver("Isack Hadjar", "HAD", 37, 78, 77, 76, 75, 74, 73, vcarb, vcarb02);
        driverRepository.save(tsunoda);
        driverRepository.save(hadjar);

        // Stake F1 Team Kick Sauber
        Team sauber = new Team("Stake F1 Team Kick Sauber", 79, 2.8, 0.5, 76);
        teamRepository.save(sauber);

        Car c45 = new Car("C45", "Ferrari", 80, 79, 78, 76, 79, sauber);
        carRepository.save(c45);

        RacingDriver hulkenberg = new RacingDriver("Nico Hülkenberg", "HUL", 27, 85, 83, 84, 82, 81, 79, sauber, c45);
        RacingDriver bortoleto = new RacingDriver("Gabriel Bortoleto", "BOR", 50, 77, 76, 75, 74, 73, 72, sauber, c45);
        driverRepository.save(hulkenberg);
        driverRepository.save(bortoleto);

        // MoneyGram Haas F1 Team
        Team haas = new Team("MoneyGram Haas F1 Team", 78, 2.9, 0.55, 75);
        teamRepository.save(haas);

        Car vf25 = new Car("VF-25", "Ferrari", 79, 78, 77, 75, 78, haas);
        carRepository.save(vf25);

        RacingDriver bearman = new RacingDriver("Oliver Bearman", "BEA", 87, 80, 79, 78, 77, 76, 75, haas, vf25);
        RacingDriver ocon = new RacingDriver("Esteban Ocon", "OCO", 31, 86, 85, 83, 84, 82, 80, haas, vf25);
        driverRepository.save(bearman);
        driverRepository.save(ocon);
    }

    private void initCircuits() {
        List<Circuit> circuits = Arrays.asList(
                new Circuit("Albert Park Circuit", "Australia", 5.303, 58, 80.0, 1.5, 3.0, 70, 85),
                new Circuit("Shanghai International Circuit", "China", 5.451, 56, 85.0, 1.6, 3.2, 65, 80),
                new Circuit("Suzuka International Racing Course", "Japan", 5.807, 53, 88.0, 1.7, 3.5, 75, 90),
                new Circuit("Bahrain International Circuit", "Bahrain", 5.412, 57, 83.0, 1.4, 2.8, 60, 75),
                new Circuit("Jeddah Corniche Circuit", "Saudi Arabia", 6.174, 50, 90.0, 1.8, 3.8, 85, 95),
                new Circuit("Miami International Autodrome", "USA", 5.412, 57, 85.5, 1.5, 3.1, 65, 80),
                new Circuit("Autodromo Internazionale Enzo e Dino Ferrari", "Italy", 4.909, 63, 77.0, 1.3, 2.7, 60, 85),
                new Circuit("Circuit de Monaco", "Monaco", 3.337, 78, 71.0, 1.2, 2.5, 90, 95),
                new Circuit("Circuit de Barcelona-Catalunya", "Spain", 4.675, 66, 78.0, 1.4, 2.9, 65, 80),
                new Circuit("Circuit Gilles Villeneuve", "Canada", 4.361, 70, 73.0, 1.3, 2.6, 70, 75),
                new Circuit("Red Bull Ring", "Austria", 4.318, 71, 68.0, 1.2, 2.4, 60, 70),
                new Circuit("Silverstone Circuit", "Great Britain", 5.891, 52, 86.0, 1.7, 3.4, 70, 80),
                new Circuit("Circuit de Spa-Francorchamps", "Belgium", 7.004, 44, 103.0, 2.0, 4.2, 75, 90),
                new Circuit("Hungaroring", "Hungary", 4.381, 70, 77.0, 1.4, 2.8, 80, 85),
                new Circuit("Circuit Zandvoort", "Netherlands", 4.259, 72, 74.0, 1.3, 2.6, 75, 80),
                new Circuit("Autodromo Nazionale Monza", "Italy", 5.793, 53, 81.0, 1.5, 3.0, 55, 70),
                new Circuit("Baku City Circuit", "Azerbaijan", 6.003, 51, 93.0, 1.8, 3.7, 85, 90),
                new Circuit("Marina Bay Street Circuit", "Singapore", 5.063, 61, 85.0, 1.6, 3.3, 90, 95),
                new Circuit("Circuit of the Americas", "USA", 5.513, 56, 88.0, 1.7, 3.5, 70, 75),
                new Circuit("Autódromo Hermanos Rodríguez", "Mexico", 4.304, 71, 75.0, 1.4, 2.8, 65, 75),
                new Circuit("Autódromo José Carlos Pace", "Brazil", 4.309, 71, 75.5, 1.4, 2.8, 70, 80),
                new Circuit("Las Vegas Street Circuit", "USA", 6.120, 50, 94.0, 1.9, 3.9, 80, 90),
                new Circuit("Lusail International Circuit", "Qatar", 5.380, 57, 84.0, 1.5, 3.0, 70, 85),
                new Circuit("Yas Marina Circuit", "Abu Dhabi", 5.281, 55, 82.0, 1.5, 2.9, 65, 75)
        );

        circuitRepository.saveAll(circuits);

    }

    private void initTires() {
        List<Tire> tires = Arrays.asList(
                new Tire("SOFT", 70, 95, 4),
                new Tire("MEDIUM", 80, 88, 3),
                new Tire("HARD", 90, 82, 2),
                new Tire("INTERMEDIATE", 85, 75, 5),
                new Tire("WET", 90, 70, 6)
        );

        tireRepository.saveAll(tires);
    }

}

