package com.cifo.airport.service;

import com.cifo.airport.model.Airport;
import com.cifo.airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    public Optional<Airport> findById(Long id) {
        return airportRepository.findById(id);
    }

    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    public void deleteById(Long id) {
        airportRepository.deleteById(id);
    }

    public void delete(Airport airport) {
        airportRepository.delete(airport);
    }

    public void deleteAll() {
        airportRepository.deleteAll();
    }

    public boolean existsById(Long id) {
        return airportRepository.existsById(id);
    }

    public long count() {
        return airportRepository.count();
    }

}