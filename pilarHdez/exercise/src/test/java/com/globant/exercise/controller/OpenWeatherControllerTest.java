package com.globant.exercise.controller;

import com.globant.exercise.exception.InvalidParameterException;
import com.globant.exercise.pojo.OpenWeatherResponse;
import com.globant.exercise.service.OpenWeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class OpenWeatherControllerTest {

    @Mock
    private OpenWeatherService openWeatherService;

    @InjectMocks
    private OpenWeatherController openWeatherController;

    @Test
    public void getWeatherByCityTestError() {
        assertThrows(InvalidParameterException.class,
                () -> openWeatherController.getWeatherByCity("1234"));
    }

    @Test
    public void getWeatherByCity() {
        String city = "Mexico";
        when(openWeatherService.getWeatherByCity(city)).thenReturn(new ResponseEntity<>(HttpStatus.ACCEPTED));

        ResponseEntity<OpenWeatherResponse> response = openWeatherController.getWeatherByCity(city);

        verify(openWeatherService, times(1)).getWeatherByCity(city);
        assertNotNull(response);
    }

    @Test
    public void getWeatherByLatitudeLongitudeTestError() {
        float latitude = Float.valueOf("91.5000");
        float longitude = Float.valueOf("-180.0000");

        assertThrows(InvalidParameterException.class,
                () -> openWeatherController.getWeatherByLatitudeLongitude(latitude, longitude));
    }

    @Test
    public void getWeatherByLatitudeLongitude() {
        float latitude = 31;
        float longitude = 36;
        when(openWeatherService.getWeatherByLatitudeLongitude(latitude, longitude))
                .thenReturn(new ResponseEntity<>(HttpStatus.ACCEPTED));

        ResponseEntity<OpenWeatherResponse> response = openWeatherController.getWeatherByLatitudeLongitude(latitude, longitude);

        verify(openWeatherService, times(1)).getWeatherByLatitudeLongitude(latitude, longitude);
        assertNotNull(response);
    }
}
