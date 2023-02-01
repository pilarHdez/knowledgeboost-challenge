package com.globant.exercise.service;

import com.globant.exercise.client.OpenWeatherClient;
import com.globant.exercise.dao.OpenWeatherDao;
import com.globant.exercise.pojo.OpenWeatherResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class OpenWeatherServiceTest {

    @Mock
    private OpenWeatherClient openWeatherClient;
    @Mock
    private OpenWeatherDao openWeatherDao;

    @InjectMocks
    private OpenWeatherService openWeatherService;

    @Test
    public void getWeatherByCity() throws NoSuchFieldException {
        OpenWeatherResponse body = new OpenWeatherResponse();
        ResponseEntity<OpenWeatherResponse> responseMock = new ResponseEntity<>(body, HttpStatus.ACCEPTED);
        String city = "Mexico";
        String appId = "example-appId";
        FieldSetter.setField(openWeatherService, openWeatherService.getClass().getDeclaredField("appId"), appId);

        when(openWeatherClient.getWeatherByCity(city, appId)).thenReturn(responseMock);

        ResponseEntity<OpenWeatherResponse> response = openWeatherService.getWeatherByCity(city);

        verify(openWeatherClient, times(1)).getWeatherByCity(city, appId);
        verify(openWeatherDao, times(1)).insertData(responseMock);

        assertNotNull(response);
    }

    @Test
    public void getWeatherByLatitudeLongitude() throws NoSuchFieldException {
        OpenWeatherResponse body = new OpenWeatherResponse();
        ResponseEntity<OpenWeatherResponse> responseMock = new ResponseEntity<>(body, HttpStatus.ACCEPTED);
        float latitude = 30;
        float longitude = 30;
        String appId = "example-appId";
        FieldSetter.setField(openWeatherService, openWeatherService.getClass().getDeclaredField("appId"), appId);

        when(openWeatherClient.getWeatherByLatitudeLongitude(latitude, longitude, appId)).thenReturn(responseMock);

        ResponseEntity<OpenWeatherResponse> response = openWeatherService.getWeatherByLatitudeLongitude(latitude,longitude);

        verify(openWeatherClient, times(1)).getWeatherByLatitudeLongitude(latitude,longitude,appId);
        verify(openWeatherDao, times(1)).insertData(responseMock);

        assertNotNull(response);
    }
}
