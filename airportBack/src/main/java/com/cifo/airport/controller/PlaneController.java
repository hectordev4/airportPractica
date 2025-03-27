package com.cifo.airport.controller;


import com.cifo.airport.model.Plane;
import com.cifo.airport.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "http://localhost:3000")
public class PlaneController {

    private final PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping
    public Page<Plane> getAllPlanes(Pageable pageable) {
        return planeService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable Long id) {
        return planeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Plane createPlane(@RequestBody Plane plane) {
        return planeService.save(plane);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plane> updatePlane(@PathVariable Long id, @RequestBody Plane plane) {
        return planeService.findById(id)
                .map(existingPlane -> {
                    plane.setId(id);
                    return ResponseEntity.ok(planeService.save(plane));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Long id) {
        return planeService.findById(id)
                .map(plane -> {
                    planeService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Plane> searchPlanes(@RequestParam String keyword) {
        return planeService.searchPlanes(keyword);
    }
}
