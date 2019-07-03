package com.sandy03934.vehicle.servicebooking.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressDetails {

    private String publicId;

    @NotNull
    private String streetAddress;

    @NotNull
    private String city;

    @NotNull
    private String zipCode;

    @NotNull
    private String country;
}
