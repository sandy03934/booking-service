package com.sandy03934.vehicle.servicebooking.services.impl;

import com.sandy03934.vehicle.servicebooking.domain.Address;
import com.sandy03934.vehicle.servicebooking.domain.Customer;
import com.sandy03934.vehicle.servicebooking.domain.Vehicle;
import com.sandy03934.vehicle.servicebooking.dtos.AddressDetails;
import com.sandy03934.vehicle.servicebooking.dtos.CustomerDetails;
import com.sandy03934.vehicle.servicebooking.dtos.Result;
import com.sandy03934.vehicle.servicebooking.dtos.VehicleDetails;
import com.sandy03934.vehicle.servicebooking.repository.CustomerRepository;
import com.sandy03934.vehicle.servicebooking.services.ICustomerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

@Service
public class CustomerProfileServiceImpl implements ICustomerProfile {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerProfileServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Result register(CustomerDetails customerDetails) {
        Objects.requireNonNull(customerDetails, "Customer Details mandatory while registering");

        String publicID = StringUtils.isEmpty(customerDetails.getPublicId()) ? UUID.randomUUID().toString() : customerDetails.getPublicId();
        customerDetails.setPublicId(publicID);
        customerRepository.save(toCustomer(customerDetails, new Customer()));

        return new Result(true, publicID);
    }

    private Customer toCustomer(CustomerDetails customerDetails, Customer customer) {
        customer.setEmail(customerDetails.getEmail());
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setPublicId(customerDetails.getPublicId());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        customer.setMiddleName(customerDetails.getMiddleName());

        return customer;
    }

    @Override
    public Result editProfile(String publicId, CustomerDetails customerDetails) {
        Objects.requireNonNull(publicId, "Provide a valid customerId for edit");
        Objects.requireNonNull(customerDetails, "Provide valid customer details for update");

        Customer customer = customerRepository.findByPublicId(publicId).orElseThrow(() -> new IllegalArgumentException("No Customer Record Exists for ID" + publicId));

        customerRepository.save(toCustomer(customerDetails, customer));

        return new Result(true, customer.getPublicId());
    }

    @Override
    public Result addAddress(String publicId, AddressDetails addressDetails) {
        Objects.requireNonNull(publicId, "Provide a valid customerId for edit");
        Objects.requireNonNull(addressDetails, "Provide valid address details for update");

        Customer customer = customerRepository.findByPublicId(publicId).orElseThrow(() -> new IllegalArgumentException("No Customer Record Exists for ID" + publicId));


        String publicID = StringUtils.isEmpty(addressDetails.getPublicId()) ? UUID.randomUUID().toString() : addressDetails.getPublicId();
        addressDetails.setPublicId(publicID);

        customer.addAddress(toAddress(addressDetails, new Address()));

        customerRepository.save(customer);

        return new Result(true, publicID);
    }

    private Address toAddress(AddressDetails addressDetails, Address address) {
        address.setCity(addressDetails.getCity());
        address.setCountry(addressDetails.getCountry());
        address.setStreetAddress(addressDetails.getStreetAddress());
        address.setZipCode(addressDetails.getZipCode());
        address.setPublicId(addressDetails.getPublicId());
        return address;
    }

    @Override
    public Result addVehicle(String publicId, VehicleDetails vehicleDetails) {
        Objects.requireNonNull(publicId, "Provide a valid customerId for edit");
        Objects.requireNonNull(vehicleDetails, "Provide valid vehicle details for update");

        Customer customer = customerRepository.findByPublicId(publicId).orElseThrow(() -> new IllegalArgumentException("No Customer Record Exists for ID" + publicId));

        String publicID = StringUtils.isEmpty(vehicleDetails.getPublicId()) ? UUID.randomUUID().toString() : vehicleDetails.getPublicId();
        vehicleDetails.setPublicId(publicID);
        customer.addVehicle(toVehicle(vehicleDetails, new Vehicle()));

        customerRepository.save(customer);

        return new Result(true, publicID);
    }

    private Vehicle toVehicle(VehicleDetails vehicleDetails, Vehicle vehicle) {
        vehicle.setChasisNumber(vehicleDetails.getChasisNumber());
        vehicle.setEngineNumber(vehicleDetails.getEngineNumber());
        vehicle.setRegNumber(vehicleDetails.getRegNumber());
        vehicle.setType(vehicleDetails.getType());
        vehicle.setPublicId(vehicleDetails.getPublicId());
        return vehicle;
    }
}
