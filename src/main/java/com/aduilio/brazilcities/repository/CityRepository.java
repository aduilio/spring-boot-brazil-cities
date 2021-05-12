package com.aduilio.brazilcities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aduilio.brazilcities.entity.City;

/**
 * Provides the access to the City database.
 */
public interface CityRepository extends JpaRepository<City, Long>
{

}
