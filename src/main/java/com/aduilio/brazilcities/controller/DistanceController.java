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
package com.aduilio.brazilcities.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.aduilio.brazilcities.dto.DistanceDto;
import com.aduilio.brazilcities.enums.DistanceUnit;
import com.aduilio.brazilcities.service.DistanceService;

/**
 * Provides resources to calculate the distance between two cities.
 */
@RestController
@RequestMapping ("/distance")
@AllArgsConstructor
public class DistanceController
{
    private final DistanceService distanceService;

    /**
     * Returns the distance between two cities.
     *
     * @param city1Id the id of the first city.
     * @param city2Id the id of the second city.
     * @param unit the desired unit
     *
     * @return Double with the distance
     */
    @GetMapping
    public ResponseEntity<DistanceDto> miles(@RequestParam (name = "from") final Long city1Id,
                                             @RequestParam (name = "to") final Long city2Id,
                                             @RequestParam (name = "unit") final DistanceUnit unit)
    {
        return ResponseEntity.ok(DistanceDto.builder()
                .distance(calculate(unit, city1Id, city2Id))
                .units(unit)
                .build());
    }

    private Double calculate(final DistanceUnit unit, final Long city1Id, final Long city2Id)
    {
        switch (unit)
        {
            case METERS:
                return distanceService.distanceMeters(city1Id, city2Id);
            case MILES:
                return distanceService.distanceMiles(city1Id, city2Id);
            default:
                return distanceService.distanceMeters(city1Id, city2Id);
        }
    }
}
