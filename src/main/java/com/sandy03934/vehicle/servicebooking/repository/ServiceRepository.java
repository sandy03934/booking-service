package com.sandy03934.vehicle.servicebooking.repository;

import com.sandy03934.vehicle.servicebooking.domain.Service;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends BaseRepository<Service, Long, String> {
}
