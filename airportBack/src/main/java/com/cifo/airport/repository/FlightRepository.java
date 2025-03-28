package com.cifo.airport.repository;

import com.cifo.airport.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFlightNumberContaining(String flightNumber);

    List<Flight> findByStatusContaining(String status);

    List<Flight> findByDepartureTimeContaining(String departureTime);

    List<Flight> findByArrivalTimeContaining(String arrivalTime);

}