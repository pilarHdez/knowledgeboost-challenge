package com.globant.exercise.controller;

import com.globant.exercise.exception.InvalidParameterException;
import com.globant.exercise.pojo.OpenWeatherResponse;
import com.globant.exercise.service.OpenWeatherService;
import com.globant.exercise.util.Coordinate;
import com.globant.exercise.util.ValidateCity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@Slf4j
public class OpenWeatherController {
    private final OpenWeatherService openWeatherService;

    @Autowired
    public OpenWeatherController(final OpenWeatherService openWeatherService) {
        this.openWeatherService = openWeatherService;
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<OpenWeatherResponse> getWeatherByCity(@PathVariable("cityName") String cityName)
            throws InvalidParameterException {
        log.info("OpenWeatherController m=getWeatherByCity, city={}", cityName);

        if (!ValidateCity.city(cityName)) {
            log.error("OpenWeatherController m=getWeatherByCity invalid params, city={}", cityName);
            throw new InvalidParameterException();
        } else {
            ResponseEntity<OpenWeatherResponse> response = openWeatherService.getWeatherByCity(cityName);
            return response;
        }
    }

    @GetMapping("/latitude/{latitude}/longitude/{longitude}")
    public ResponseEntity<OpenWeatherResponse> getWeatherByLatitudeLongitude(@PathVariable("latitude") float latitude,
                                                                             @PathVariable("longitude") float longitude)
            throws InvalidParameterException {
        log.info("OpenWeatherController m=getWeatherByLatitudeLongitude, latitude={} longitude={}", latitude, longitude);

        if (!Coordinate.isValidLatitude(latitude) || !Coordinate.isValidLongitude(longitude)) {
            log.error("OpenWeatherController m=getWeatherByLatitudeLongitude invalid params, " +
                    "latitude={} longitude={}", latitude, longitude);
            throw new InvalidParameterException();
        } else {
            ResponseEntity<OpenWeatherResponse> response =
                    openWeatherService.getWeatherByLatitudeLongitude(latitude, longitude);
            return response;
        }
    }
}
