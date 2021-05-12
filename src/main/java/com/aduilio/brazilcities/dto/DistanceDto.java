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
package com.aduilio.brazilcities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.aduilio.brazilcities.enums.DistanceUnit;

/**
 * DTO for distance.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistanceDto
{
    private Double distance;

    private DistanceUnit units;
}
