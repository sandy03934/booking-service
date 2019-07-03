package com.sandy03934.vehicle.servicebooking.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID, PID> extends PagingAndSortingRepository<T, ID> {

    Optional<T> findByPublicId(PID publicID);
}
