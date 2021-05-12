package com.aduilio.brazilcities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aduilio.brazilcities.entity.City;

/**
 * Provides the access to the City database.
 */
public interface CityRepository extends JpaRepository<City, Long>
{
    /**
     * Execute a query to calculate the distance using the EarthDistance extension.
     *
     * @param city1Id the id of the first city
     * @param city2Id the id of the second city
     *
     * @return Double with the distance in miles
     */
    @Query (value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance",
            nativeQuery = true)
    Double distanceByPoints(Long city1Id, Long city2Id);

    /**
     * Execute a query to calculate the distance using the Cube extension.
     *
     * @param lat1 the latitude of the first city
     * @param lon1 the longitude of the first city
     * @param lat2 the latitude of the second city
     * @param lon2 the longitude of the second city
     *
     * @return Double with the distance in meters
     */
    @Query (value = "SELECT earth_distance (ll_to_earth(?1, ?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(Double lat1, Double lon1, Double lat2, Double lon2);
}
