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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.aduilio.brazilcities.dto.CityDto;
import com.aduilio.brazilcities.entity.City;

/**
 * Provides the mapping for {@link City}.
 */
@Mapper
public interface CityMapper
{
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping (source = "state.name", target = "state")
    CityDto mapCityDtoFrom(City city);
}
