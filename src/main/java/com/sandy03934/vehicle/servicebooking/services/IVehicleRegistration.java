package com.sandy03934.vehicle.servicebooking.services;

import com.sandy03934.vehicle.servicebooking.dtos.Result;
import com.sandy03934.vehicle.servicebooking.dtos.VehicleDetails;

public interface IVehicleRegistration {

    Result registerVehicle(String customerId, VehicleDetails vehicleDetails);

    Result editVehicleDetails(String customerId, VehicleDetails vehicleDetails);
}
