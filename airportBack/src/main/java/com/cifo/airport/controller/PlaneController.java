package com.cifo.airport.controller;

import com.cifo.airport.model.Plane;
import com.cifo.airport.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @GetMapping
    public List<Plane> findAll() {
        return planeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plane> findById(@PathVariable Long id) {
        Optional<Plane> plane = planeService.findById(id);
        if (plane.isPresent()) {
            return ResponseEntity.ok(plane.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Plane> create(@RequestBody Plane plane) {
        return ResponseEntity.ok(planeService.save(plane));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plane> update(@PathVariable Long id, @RequestBody Plane plane) {
        Optional<Plane> existingPlane = planeService.findById(id);
        if (existingPlane.isPresent()) {
            plane.setId(id);
            return ResponseEntity.ok(planeService.save(plane));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Plane> plane = planeService.findById(id);
        if (plane.isPresent()) {
            planeService.delete(plane.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}