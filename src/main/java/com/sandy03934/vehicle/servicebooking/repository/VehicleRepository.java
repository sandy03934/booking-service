package com.sandy03934.vehicle.servicebooking.repository;

import com.sandy03934.vehicle.servicebooking.domain.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends BaseRepository<Vehicle, Long, String> {
}
