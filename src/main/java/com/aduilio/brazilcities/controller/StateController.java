package com.aduilio.brazilcities.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import com.aduilio.brazilcities.entity.State;
import com.aduilio.brazilcities.repository.StateRepository;

/**
 * Provides the resources to access states.
 */
@RestController
@RequestMapping ("/states")
@AllArgsConstructor
public class StateController
{
    private final StateRepository stateRepository;

    /**
     * Returns all the states.
     *
     * @param page with query parameters
     *
     * @return {@link Page} of {@link State}
     */
    @GetMapping
    public Page<State> list(final Pageable page)
    {
        return stateRepository.findAll(page);
    }

    /**
     * Returns a specific state by id.
     *
     * @param id of the desired state
     *
     * @return {@link State}
     */
    @GetMapping ("/{id}")
    public ResponseEntity<State> read(@PathVariable final Long id)
    {
        return stateRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
