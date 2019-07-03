package com.sandy03934.vehicle.servicebooking.dtos;

import com.sandy03934.vehicle.servicebooking.domain.VehicleType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VehicleDetails {

    private String publicId;

    @NotNull
    private String regNumber;

    @NotNull
    private String engineNumber;

    @NotNull
    private String chasisNumber;

    @NotNull
    private VehicleType type;
}
