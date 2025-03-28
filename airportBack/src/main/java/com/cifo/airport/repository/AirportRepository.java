package com.cifo.airport.repository;

import com.cifo.airport.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByNameContaining(String name);

    List<Airport> findByCityContaining(String city);

    List<Airport> findByCountryContaining(String country);

}