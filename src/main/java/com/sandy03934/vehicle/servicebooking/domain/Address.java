package com.sandy03934.vehicle.servicebooking.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Address extends BaseEntity {

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String zipCode;

    @Column(name = "country")
    private String country;
}
