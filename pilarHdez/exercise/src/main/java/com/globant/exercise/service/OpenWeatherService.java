package com.globant.exercise.service;

import com.globant.exercise.client.OpenWeatherClient;
import com.globant.exercise.dao.OpenWeatherDao;
import com.globant.exercise.pojo.OpenWeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
@Slf4j
public class OpenWeatherService {
    private final OpenWeatherClient openWeatherClient;
    private final OpenWeatherDao openWeatherDao;
    @Value("${openweather.api.key}")
    private String appId;

    @Autowired
    public OpenWeatherService(final OpenWeatherClient openWeatherClient,
                              final OpenWeatherDao openWeatherDao) {
        this.openWeatherClient = openWeatherClient;
        this.openWeatherDao = openWeatherDao;
    }

    public ResponseEntity<OpenWeatherResponse> getWeatherByCity(String city) {
        log.info("OpenWeatherService m=getWeatherByCity, city={}", city);
        ResponseEntity<OpenWeatherResponse> response = openWeatherClient.getWeatherByCity(city, appId);

        openWeatherDao.insertData(response);

        log.info("OpenWeatherService m=getWeatherByCity completed");
        return response;
    }

    public ResponseEntity<OpenWeatherResponse> getWeatherByLatitudeLongitude(float latitude, float longitude) {
        log.info("OpenWeatherService m=getWeatherByLatitudeLongitude, latitude={} longitude={}", latitude, longitude);

        ResponseEntity<OpenWeatherResponse> response =
                openWeatherClient.getWeatherByLatitudeLongitude(latitude, longitude, appId);

        openWeatherDao.insertData(response);

        log.info("OpenWeatherService m=getWeatherByLatitudeLongitude completed");
        return response;

    }
}
