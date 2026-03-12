package com.example.backend.DTOs;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class WeatherDTO {

    private Long id;

    @NotBlank(message = "City name is required")
    private String cityName;

    @NotBlank(message = "Region is required")
    private String region;

    @DecimalMin(value = "-90.0", message = "Latitude must be >= -90")
    @DecimalMax(value = "90.0", message = "Latitude must be <= 90")
    private double latitude;

    @DecimalMin(value = "-180.0", message = "Longitude must be >= -180")
    @DecimalMax(value = "180.0", message = "Longitude must be <= 180")
    private double longitude;

    private double temperature;

    private Long timestamp;
}