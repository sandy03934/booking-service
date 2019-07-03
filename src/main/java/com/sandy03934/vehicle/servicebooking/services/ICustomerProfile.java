package com.sandy03934.vehicle.servicebooking.services;

import com.sandy03934.vehicle.servicebooking.dtos.AddressDetails;
import com.sandy03934.vehicle.servicebooking.dtos.CustomerDetails;
import com.sandy03934.vehicle.servicebooking.dtos.Result;
import com.sandy03934.vehicle.servicebooking.dtos.VehicleDetails;

public interface ICustomerProfile {

    Result register(CustomerDetails customerDetails);

    Result editProfile(String publicId, CustomerDetails customerDetails);

    Result addAddress(String publicId, AddressDetails addressDetails);

    Result addVehicle(String publicId, VehicleDetails vehicleDetails);
}
