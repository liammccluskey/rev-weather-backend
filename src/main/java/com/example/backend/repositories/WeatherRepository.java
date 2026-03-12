package com.example.backend.repositories;

import com.example.backend.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    @Query("""
        SELECT w FROM Weather w
        WHERE (:location IS NULL OR LOWER(w.cityName) = LOWER(:cityName))
        AND (:region IS NULL OR LOWER(w.cityName) = LOWER(:cityName))
    """)
    List<Weather> findWeathers(@Param("cityName") String cityName, @Param("region") String region);
}
