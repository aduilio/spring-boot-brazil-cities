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
package com.aduilio.brazilcities.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.aduilio.brazilcities.dto.StateDto;
import com.aduilio.brazilcities.entity.State;

/**
 * Provides the mapping for {@link State}.
 */
@Mapper
public interface StateMapper
{
    StateMapper INSTANCE = Mappers.getMapper(StateMapper.class);

    @Mapping (source = "country.ptName", target = "country")
    @Mapping (source = "ddd", target = "ddd", qualifiedByName = "mapDddFrom")
    StateDto mapStateDtoFrom(State state);

    @Named ("mapDddFrom")
    default String mapDddFrom(final List<Integer> ddd)
    {
        if (ddd != null)
        {
            return String.join(", ", ddd.stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.toList()));
        }

        return null;
    }
}
