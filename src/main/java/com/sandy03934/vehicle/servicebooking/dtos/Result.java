package com.sandy03934.vehicle.servicebooking.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Result {


    boolean success;

    String publicId;
}
