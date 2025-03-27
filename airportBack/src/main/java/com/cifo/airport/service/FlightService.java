package com.cifo.airport.service;


import com.cifo.airport.model.Flight;
import com.cifo.airport.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Page<Flight> findAll(Pageable pageable) {
        return flightRepository.findAll(pageable);
    }

    public Page<Flight> findAll(Specification<Flight> spec, Pageable pageable) {
        return flightRepository.findAll(spec, pageable);
    }

    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteById(Long id) {
        flightRepository.deleteById(id);
    }

    public Flight findByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }

    public List<Flight> findByDepartureTime(LocalDateTime departureTime) {
        return flightRepository.findByDepartureTime(departureTime);
    }

    public List<Flight> findByArrivalTime(LocalDateTime arrivalTime) {
        return flightRepository.findByArrivalTime(arrivalTime);
    }

    public Page<Flight> findByStatus(String status) {
        return flightRepository.findByStatus(status);
    }

    public List<Flight> searchFlights(String keyword) {
        return flightRepository.searchFlights(keyword);
    }

}


