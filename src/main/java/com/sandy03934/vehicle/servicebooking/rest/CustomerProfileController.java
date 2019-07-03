package com.sandy03934.vehicle.servicebooking.rest;

import com.sandy03934.vehicle.servicebooking.dtos.AddressDetails;
import com.sandy03934.vehicle.servicebooking.dtos.CustomerDetails;
import com.sandy03934.vehicle.servicebooking.dtos.Result;
import com.sandy03934.vehicle.servicebooking.dtos.VehicleDetails;
import com.sandy03934.vehicle.servicebooking.services.ICustomerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/customer")
public class CustomerProfileController {


    private final ICustomerProfile customerProfileService;

    @Autowired
    public CustomerProfileController(ICustomerProfile customerRegistrationService) {
        this.customerProfileService = customerRegistrationService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody @NotNull CustomerDetails customerDetails) {
           Result result = customerProfileService.register(customerDetails);

           return result.isSuccess() ? new ResponseEntity<>(result.getPublicId(), HttpStatus.CREATED)
                   : new ResponseEntity<>("Couldn't Register the customer at the moment", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/{publicId}/profile/edit")
    public ResponseEntity<String> editProfile(@RequestBody @NotNull CustomerDetails customerDetails, @PathVariable String publicId) {
        Result result = customerProfileService.editProfile(publicId, customerDetails);

        return result.isSuccess() ? new ResponseEntity<>(result.getPublicId(), HttpStatus.OK)
                : new ResponseEntity<>("Couldn't Register the customer at the moment", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/{publicId}/address")
    public ResponseEntity<String> addAddress(@RequestBody @NotNull AddressDetails addressDetails, @PathVariable String publicId) {
        Result result = customerProfileService.addAddress(publicId, addressDetails);

        return result.isSuccess() ? new ResponseEntity<>(result.getPublicId(), HttpStatus.OK)
                : new ResponseEntity<>("Couldn't add the address at the moment", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/{publicId}/vehicle")
    public ResponseEntity<String> addVehicleDetails(@RequestBody @NotNull VehicleDetails vehicleDetails, @PathVariable String publicId) {
        Result result = customerProfileService.addVehicle(publicId, vehicleDetails);

        return result.isSuccess() ? new ResponseEntity<>(result.getPublicId(), HttpStatus.OK)
                : new ResponseEntity<>("Couldn't add the address at the moment", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}