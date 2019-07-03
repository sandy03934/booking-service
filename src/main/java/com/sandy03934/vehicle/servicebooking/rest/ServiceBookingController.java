package com.sandy03934.vehicle.servicebooking.rest;

import com.sandy03934.vehicle.servicebooking.dtos.BookingRequest;
import com.sandy03934.vehicle.servicebooking.dtos.Result;
import com.sandy03934.vehicle.servicebooking.services.IServiceBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceBookingController {

    @Autowired
    IServiceBooking serviceBooking;

    @PostMapping("/customer/{customerId}/vehicle/{vehicleId}/book")
    public ResponseEntity<String> bookService(@RequestBody BookingRequest request,
                                              @PathVariable String customerId,
                                              @PathVariable String vehicleId) {
        Result result = serviceBooking.bookService(customerId, vehicleId, request);
        return result.isSuccess() ? new ResponseEntity<>(result.getPublicId(), HttpStatus.CREATED)
                : new ResponseEntity<>("Couldn't Register the customer at the moment", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
