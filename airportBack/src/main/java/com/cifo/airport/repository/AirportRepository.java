package com.cifo.airport.repository;


import com.cifo.airport.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>, JpaSpecificationExecutor<Airport> {

    // Find airports by country
    List<Airport> findByCountry(String country);

    // Find airports by city
    List<Airport> findByCity(String city);

    // Find airport by code
    Airport findByCode(String code);

    // Custom query example
    @Query("SELECT a FROM Airport a WHERE a.name LIKE %:keyword% OR a.code LIKE %:keyword%")
    List<Airport> searchAirports(@Param("keyword") String keyword);
}