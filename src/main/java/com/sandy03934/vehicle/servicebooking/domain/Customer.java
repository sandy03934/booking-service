package com.sandy03934.vehicle.servicebooking.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "middle_name")
    private String middleName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    public void addAddress(Address address) {
        if (addresses == null) {
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(address);
    }

    public void addVehicle(Vehicle toVehicle) {
        if (vehicles == null) {
            this.vehicles = new ArrayList<>();
        }
        this.vehicles.add(toVehicle);
    }
}
