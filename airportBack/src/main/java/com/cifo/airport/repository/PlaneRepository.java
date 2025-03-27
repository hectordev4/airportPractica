package com.cifo.airport.repository;


import com.cifo.airport.model.Plane;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long>, JpaSpecificationExecutor<Plane> {

    // Find planes by model
    List<Plane> findByModel(String model);

    // Find planes by manufacturer
    List<Plane> findByManufacturer(String manufacturer);

    // Find planes by registration number
    Plane findByRegistrationNumber(String registrationNumber);

    // Find planes by capacity
    List<Plane> findByCapacity(String capacity);

    // Find planes by year of manufacturer
    List<Plane> findByYearOfManufacture(String yearOfManufacture);

    @Query("SELECT a FROM Airport a WHERE a.model LIKE %:keyword% OR a.registrationNumber LIKE %:keyword%")
    List<Plane> searchPlanes(@Param("keyword") String keyword);

}