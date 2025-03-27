package com.cifo.airport.repository;


import com.cifo.airport.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {

    // Find flights by flight number
    Flight findByFlightNumber(String flightNumber);

    // Find flights by departure time
    List<Flight> findByDepartureTime(LocalDateTime departureTime);

    // Find flights by arrival time
    List<Flight> findByArrivalTime(LocalDateTime arrivalTime);

    // Find flights departing between times
    List<Flight> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);

    // Find flights with pagination
    Page<Flight> findByStatus(String status);

    // Custom query to find delayed flights
    @Query("SELECT f FROM Flight f WHERE f.departureTime < CURRENT_TIMESTAMP AND f.status != 'DEPARTED'")
    List<Flight> findDelayedFlights();

    // Custom query to search flights by keyword
    @Query("SELECT f FROM Flight f WHERE f.flightNumber LIKE %:keyword% OR f.status LIKE %:keyword%")
    List<Flight> searchFlights(@Param("keyword") String keyword);
}
