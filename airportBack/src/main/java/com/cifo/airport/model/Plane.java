package com.cifo.airport.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String manufacturer;
    private String registrationNumber;
    private String capacity;
    private String yearOfManufacture;

    @Getter
    @Setter

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    private List<Flight> flights;
}
