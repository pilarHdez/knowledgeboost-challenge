package com.globant.exercise.dao;

import com.globant.exercise.pojo.OpenWeatherResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class OpenWeatherDao {
    private final JdbcTemplate jdbcTemplate;
    private final Gson gson;

    @Autowired
    public OpenWeatherDao(final JdbcTemplate jdbcTemplate,
                          final Gson gson) {
        this.jdbcTemplate = jdbcTemplate;
        this.gson = gson;
    }

    public void insertData(ResponseEntity<OpenWeatherResponse> response) {
        log.info("OpenWeatherDao m=insertData, response={}", response);
        String sql = "INSERT INTO open_weather " +
                "(response_code, city, response_data) " +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                response.getStatusCodeValue(),
                response.getBody().name,
                gson.toJson(response.getBody())
        );

    }
}
