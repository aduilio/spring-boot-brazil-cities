package com.aduilio.brazilcities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aduilio.brazilcities.entity.State;

/**
 * Provides the access to the State database.
 */
public interface StateRepository extends JpaRepository<State, Long>
{

}
