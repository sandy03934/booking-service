package com.sandy03934.vehicle.servicebooking.repository;

import com.sandy03934.vehicle.servicebooking.domain.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long, String> {

}

