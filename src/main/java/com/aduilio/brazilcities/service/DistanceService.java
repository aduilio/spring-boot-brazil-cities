//**********************************************************************
// Copyright (c) 2021 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package com.aduilio.brazilcities.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.aduilio.brazilcities.entity.City;
import com.aduilio.brazilcities.repository.CityRepository;

/**
 * Provides the method to calculate distance.
 */
@Service
@AllArgsConstructor
public class DistanceService
{
    private final CityRepository cityRepository;

    /**
     * Returns the distance between two cities in miles.
     *
     * @param city1Id the id of the first city.
     * @param city2Id the id of the second city.
     *
     * @return Double with the distance in miles
     */
    public Double distanceMiles(final Long city1Id, final Long city2Id)
    {
        return cityRepository.distanceByPoints(city1Id, city2Id);
    }

    /**
     * Returns the distance between two cities in meters.
     *
     * @param city1Id the id of the first city.
     * @param city2Id the id of the second city.
     *
     * @return Double with the distance in meters
     */
    public Double distanceMeters(final Long city1Id, final Long city2Id)
    {
        final List<City> cities = cityRepository.findAllById(Arrays.asList(city1Id, city2Id));

        if (cities.size() == 2)
        {
            return cityRepository.distanceByCube(cities.get(0).getLocation().getX(),
                    cities.get(0).getLocation().getY(),
                    cities.get(1).getLocation().getX(),
                    cities.get(1).getLocation().getY());
        }

        return null;
    }
}
