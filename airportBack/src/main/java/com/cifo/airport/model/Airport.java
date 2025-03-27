package com.cifo.airport.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private String city;
    private String country;

    @Getter
    @Setter

    @OneToMany(mappedBy = "departureAirport", cascade = CascadeType.ALL)
    private List<Flight> departingFlights;

    @Getter
    @Setter

    @OneToMany(mappedBy = "arrivalAirport", cascade = CascadeType.ALL)
    private List<Flight> arrivingFlights;
}