package com.aduilio.brazilcities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aduilio.brazilcities.entity.Country;

/**
 * Provides the access to the Country database.
 */
public interface CountryRepository extends JpaRepository<Country, Long>
{

}
