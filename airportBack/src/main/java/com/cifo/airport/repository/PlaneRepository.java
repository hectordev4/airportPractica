package com.cifo.airport.repository;

import com.cifo.airport.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {

    List<Plane> findByModelContaining(String model);

    List<Plane> findByManufacturerContaining(String manufacturer);

    List<Plane> findByRegistrationNumberContaining(String registrationNumber);

    List<Plane> findByCapacity(Integer capacity);

    List<Plane> findByYearOfManufacture(Integer yearOfManufacture);

}