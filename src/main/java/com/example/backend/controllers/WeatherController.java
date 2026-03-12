package com.example.backend.controllers;

import com.example.backend.DTOs.WeatherDTO;
import com.example.backend.entities.Weather;
import com.example.backend.services.WeatherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<List<Weather>> getBooks(
            @RequestParam(required = false) String cityName,
            @RequestParam(required = false) String region
    ) {
        List<Weather> weathers = weatherService.getWeathers(cityName, region);

        return ResponseEntity.ok(weathers);
    }

    @GetMapping("/{weatherId}")
    public ResponseEntity<Weather> getBook(@PathVariable Long weatherId) {
        Weather weather = weatherService.getWeathersById(weatherId);

        return ResponseEntity.ok(weather);
    }

    @PostMapping
    public ResponseEntity<Weather> createBook(@Valid @RequestBody WeatherDTO weatherDTO) {
        Weather weather = weatherService.createWeather(weatherDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(weather);
    }
}
