package com.cifo.airport.controller;

import com.cifo.airport.model.Flight;
import com.cifo.airport.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findById(@PathVariable Long id) {
        Optional<Flight> flight = flightService.findById(id);
        if (flight.isPresent()) {
            return ResponseEntity.ok(flight.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Flight> create(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.save(flight));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> update(@PathVariable Long id, @RequestBody Flight flight) {
        Optional<Flight> existingFlight = flightService.findById(id);
        if (existingFlight.isPresent()) {
            flight.setId(id);
            return ResponseEntity.ok(flightService.save(flight));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Flight> flight = flightService.findById(id);
        if (flight.isPresent()) {
            flightService.delete(flight.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}