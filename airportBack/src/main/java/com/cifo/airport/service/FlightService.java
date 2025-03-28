package com.cifo.airport.service;

import com.cifo.airport.model.Flight;
import com.cifo.airport.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findAll() {
        return flightRepository.findAll();
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

    public void delete(Flight flight) {
        flightRepository.delete(flight);
    }

    public void deleteAll() {
        flightRepository.deleteAll();
    }

    public boolean existsById(Long id) {
        return flightRepository.existsById(id);
    }

    public long count() {
        return flightRepository.count();
    }

}