package com.cifo.airport.service;


import com.cifo.airport.model.Plane;
import com.cifo.airport.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public List<Plane> findAll() {
        return planeRepository.findAll();
    }

    public Page<Plane> findAll(Pageable pageable) {
        return planeRepository.findAll(pageable);
    }

    public Page<Plane> findAll(Specification<Plane> spec, Pageable pageable) {
        return planeRepository.findAll(spec, pageable);
    }

    public Optional<Plane> findById(Long id) {
        return planeRepository.findById(id);
    }

    public Plane save(Plane plane) {
        return planeRepository.save(plane);
    }

    public void deleteById(Long id) {
        planeRepository.deleteById(id);
    }

    public List<Plane> findByModel(String model) {
        return planeRepository.findByModel(model);
    }

    public List<Plane> findByManufacturer(String manufacturer) {
        return planeRepository.findByManufacturer(manufacturer);
    }

    public Plane findByRegistrationNumber(String registrationNumber) {
        return planeRepository.findByRegistrationNumber(registrationNumber);
    }

    public List<Plane> findByCapacity(String capacity) {
        return planeRepository.findByCapacity(capacity);
    }

    public List<Plane> findByYearOfManufacture(String yearOfManufacture) {
        return planeRepository.findByYearOfManufacture(yearOfManufacture);
    }

    public List<Plane> searchPlanes(String keyword) {
        return planeRepository.searchPlanes(keyword);
    }

}

