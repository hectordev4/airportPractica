package com.cifo.airport.specification;


import com.cifo.airport.model.Airport;
import org.springframework.data.jpa.domain.Specification;

public class AirportSpecifications {

    public static Specification<Airport> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Airport> inCountry(String country) {
        return (root, query, criteriaBuilder) ->
                country == null ? null : criteriaBuilder.equal(root.get("country"), country);
    }

    public static Specification<Airport> inCity(String city) {
        return (root, query, criteriaBuilder) ->
                city == null ? null : criteriaBuilder.equal(root.get("city"), city);
    }
}
