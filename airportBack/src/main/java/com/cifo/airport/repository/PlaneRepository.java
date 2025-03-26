package com.cifo.airport.repository;

import com.cifo.airport.model.Plane;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long>, JpaSpecificationExecutor<Plane> {

    // Find planes by model
    List<Plane> findByModel(String planeModel);

    // Find planes by manufacturer
    List<Plane> findByManufacturer(String planeManufacturer);

    // Find planes by registration number
    Plane findByRegistrationNumber(String planeRegistrationNumber);

    // Find planes by capacity
    List<Plane> findByCapacity(int planeCapacity);

    // Find planes by year of manufacture
    List<Plane> findByYearOfManufacture(int planeYearOfManufacture);

    // Find planes with pagination
    Page<Plane> findByStatus(String status, Pageable pageable);

}