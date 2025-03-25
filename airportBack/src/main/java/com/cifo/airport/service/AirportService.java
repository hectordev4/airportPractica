package com.cifo.airport.service;


import com.cifo.airport.model.Airport;
import com.cifo.airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    public Page<Airport> findAll(Pageable pageable) {
        return airportRepository.findAll(pageable);
    }

    public Page<Airport> findAll(Specification<Airport> spec, Pageable pageable) {
        return airportRepository.findAll(spec, pageable);
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

    public List<Airport> findByCountry(String country) {
        return airportRepository.findByCountry(country);
    }

    public List<Airport> findByCity(String city) {
        return airportRepository.findByCity(city);
    }

    public Airport findByCode(String code) {
        return airportRepository.findByCode(code);
    }

    public List<Airport> searchAirports(String keyword) {
        return airportRepository.searchAirports(keyword);
    }
}
