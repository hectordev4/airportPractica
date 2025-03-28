package com.cifo.airport.controller;

import com.cifo.airport.model.Airport;
import com.cifo.airport.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> findAll() {
        return airportService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> findById(@PathVariable Long id) {
        Optional<Airport> airport = airportService.findById(id);
        if (airport.isPresent()) {
            return ResponseEntity.ok(airport.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Airport> create(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.save(airport));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> update(@PathVariable Long id, @RequestBody Airport airport) {
        Optional<Airport> existingAirport = airportService.findById(id);
        if (existingAirport.isPresent()) {
            airport.setId(id);
            return ResponseEntity.ok(airportService.save(airport));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Airport> airport = airportService.findById(id);
        if (airport.isPresent()) {
            airportService.delete(airport.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}