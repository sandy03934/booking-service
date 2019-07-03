package com.sandy03934.vehicle.servicebooking.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Service extends BaseEntity {

    @Column(name = "booking_date")
    private long bookingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
