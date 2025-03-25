package com.cifo.airport.repository;


import com.cifo.airport.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {

    // Find flights by departure airport code
    List<Flight> findByDepartureAirport_Code(String airportCode);

    // Find flights by arrival airport code
    List<Flight> findByArrivalAirport_Code(String airportCode);

    // Find flights by flight number
    Flight findByFlightNumber(String flightNumber);

    // Find flights departing between times
    List<Flight> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);

    // Find flights with pagination
    Page<Flight> findByStatus(String status, Pageable pageable);

    // Custom query to find delayed flights
    @Query("SELECT f FROM Flight f WHERE f.departureTime < CURRENT_TIMESTAMP AND f.status != 'DEPARTED'")
    List<Flight> findDelayedFlights();
}
