package com.sandy03934.vehicle.servicebooking.services.impl;

import com.sandy03934.vehicle.servicebooking.domain.Customer;
import com.sandy03934.vehicle.servicebooking.domain.Service;
import com.sandy03934.vehicle.servicebooking.domain.Vehicle;
import com.sandy03934.vehicle.servicebooking.dtos.BookingRequest;
import com.sandy03934.vehicle.servicebooking.dtos.Result;
import com.sandy03934.vehicle.servicebooking.repository.CustomerRepository;
import com.sandy03934.vehicle.servicebooking.repository.ServiceRepository;
import com.sandy03934.vehicle.servicebooking.repository.VehicleRepository;
import com.sandy03934.vehicle.servicebooking.services.IServiceBooking;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.UUID;

@org.springframework.stereotype.Service
public class BookingServiceImpl implements IServiceBooking {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Result bookService(String customerId, String vehicleId, BookingRequest bookingDetails) {
        Objects.requireNonNull(customerId, "Provide a valid customerId for edit");
        Objects.requireNonNull(vehicleId, "Provide valid vehicleId for booking update");

        Customer customer = customerRepository.findByPublicId(customerId).orElseThrow(() -> new IllegalArgumentException("No Customer Record Exists for ID" + customerId));
        Vehicle vehicle = vehicleRepository.findByPublicId(vehicleId).orElseThrow(() -> new IllegalArgumentException("No Vehicle Registered with the given ID " + vehicleId));

        if (!customer.getVehicles().contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle Not Registered with this customer");
        }

        Service service = new Service();
        service.setCustomer(customer);
        service.setVehicle(vehicle);
        serviceRepository.save(toService(bookingDetails, service));

        return new Result(true, service.getPublicId());
    }

    private Service toService(BookingRequest bookingDetails, Service service) {
        service.setBookingDate(bookingDetails.getServiceDate().getTime());
        service.setPublicId(UUID.randomUUID().toString());
        return service;
    }
}
