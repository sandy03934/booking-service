package com.sandy03934.vehicle.servicebooking.repository;

import com.sandy03934.vehicle.servicebooking.domain.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}
