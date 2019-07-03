package com.sandy03934.vehicle.servicebooking.services;

import com.sandy03934.vehicle.servicebooking.dtos.BookingRequest;
import com.sandy03934.vehicle.servicebooking.dtos.Result;

public interface IServiceBooking {

    Result bookService(String customerId, String vehicleId, BookingRequest bookingDetails);
}
