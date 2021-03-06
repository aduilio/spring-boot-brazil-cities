package com.aduilio.brazilcities.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.aduilio.brazilcities.dto.CityDto;
import com.aduilio.brazilcities.entity.City;
import com.aduilio.brazilcities.mapper.CityMapper;
import com.aduilio.brazilcities.repository.CityRepository;

/**
 * Provides the resources to access cities.
 */
@RestController
@RequestMapping ("/cities")
@AllArgsConstructor
public class CityController
{
    private final CityRepository cityRepository;

    /**
     * Returns all the cities.
     *
     * @param page with query parameters
     *
     * @return {@link Page} of {@link City}
     */
    @GetMapping
    public Page<CityDto> list(final Pageable page)
    {
        return cityRepository
                .findAll(page)
                .map(CityMapper.INSTANCE::mapCityDtoFrom);
    }

    /**
     * Returns a specific city by id.
     *
     * @param id of the desired city
     *
     * @return {@link City}
     */
    @GetMapping ("/{id}")
    public ResponseEntity<CityDto> read(@PathVariable final Long id)
    {
        return cityRepository.findById(id)
                .map(CityMapper.INSTANCE::mapCityDtoFrom)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
