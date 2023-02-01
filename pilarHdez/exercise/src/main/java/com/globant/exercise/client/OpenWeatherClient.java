package com.globant.exercise.client;

import com.globant.exercise.pojo.OpenWeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "openweather", url = "${openweather.api.url}")
public interface OpenWeatherClient {
    @RequestMapping(method = RequestMethod.GET, value = "?q={city}&appid={appId}")
    ResponseEntity<OpenWeatherResponse> getWeatherByCity(@PathVariable("city") String city,
                                                         @PathVariable("appId") String appId);

    @RequestMapping(method = RequestMethod.GET, value = "?lat={lat}&lon={lon}&appid={appId}")
    ResponseEntity<OpenWeatherResponse> getWeatherByLatitudeLongitude(@PathVariable("lat") float latitude,
                                                                      @PathVariable("lon") float longitude,
                                                                      @PathVariable("appId") String appId);
}
