package com.aduilio.brazilcities.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.aduilio.brazilcities.dto.CountryDto;
import com.aduilio.brazilcities.entity.Country;
import com.aduilio.brazilcities.mapper.CountryMapper;
import com.aduilio.brazilcities.repository.CountryRepository;

/**
 * Provides the resources to access countries.
 */
@RestController
@RequestMapping ("/countries")
@AllArgsConstructor
public class CountryController
{
    private final CountryRepository countryRepository;

    /**
     * Returns all the countries.
     *
     * @param page with query parameters
     *
     * @return {@link Page} of {@link Country}
     */
    @GetMapping
    public Page<CountryDto> list(final Pageable page)
    {
        return countryRepository
                .findAll(page)
                .map(CountryMapper.INSTANCE::mapCountryDtoFrom);
    }

    /**
     * Returns a specific country by id.
     *
     * @param id of the desired country
     *
     * @return {@link Country}
     */
    @GetMapping ("/{id}")
    public ResponseEntity<CountryDto> read(@PathVariable final Long id)
    {
        return countryRepository.findById(id)
                .map(CountryMapper.INSTANCE::mapCountryDtoFrom)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
