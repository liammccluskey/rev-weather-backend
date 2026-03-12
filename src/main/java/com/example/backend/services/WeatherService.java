package com.example.backend.services;

import com.example.backend.DTOs.WeatherDTO;
import com.example.backend.entities.Weather;
import com.example.backend.exceptions.ApiException;
import com.example.backend.repositories.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public List<Weather> getWeathers(String cityName, String region) {
        return weatherRepository.findWeathers(cityName, region);
    }

    public Weather getWeathersById(Long id) {
        return weatherRepository.findById(id)
                .orElseThrow(() -> new ApiException(
                        "Could not find a weather record with this id",
                        HttpStatus.NOT_FOUND
                ));
    }

    public Weather createWeather(WeatherDTO weatherDTO) {
        Weather weather = Weather.builder()
                .cityName(weatherDTO.getCityName())
                .region(weatherDTO.getRegion())
                .latitude(weatherDTO.getLatitude())
                .longitude(weatherDTO.getLongitude())
                .temperature(weatherDTO.getTemperature())
                .timestamp(Instant.ofEpochMilli(weatherDTO.getTimestamp()))
                .build();

        return weatherRepository.save(weather);
    }
}
