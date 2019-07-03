package com.sandy03934.vehicle.servicebooking.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Vehicle extends BaseEntity {

    @Column(name = "registration_number")
    private String regNumber;

    @Column(name = "engine_number")
    private String engineNumber;

    @Column(name = "chasis_number")
    private String chasisNumber;

    @Column(name = "type")
    private VehicleType type;

}
