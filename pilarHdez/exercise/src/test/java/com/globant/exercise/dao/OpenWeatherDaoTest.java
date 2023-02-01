package com.globant.exercise.dao;

import com.globant.exercise.config.MainConfig;
import com.globant.exercise.pojo.OpenWeatherResponse;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class OpenWeatherDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    private Gson gson = new MainConfig().gson();

    @InjectMocks
    private OpenWeatherDao openWeatherDao;

    @Test
    public void insertDataTest() throws NoSuchFieldException {
        FieldSetter.setField(openWeatherDao, openWeatherDao.getClass().getDeclaredField("gson"), gson);
        OpenWeatherResponse body = new OpenWeatherResponse();
        ResponseEntity<OpenWeatherResponse> responseMock = new ResponseEntity<>(body, HttpStatus.ACCEPTED);

        when(jdbcTemplate.update(anyString(), any(), any(), any())).thenReturn(0);

        openWeatherDao.insertData(responseMock);

        verify(jdbcTemplate, times(1)).update(anyString(), any(), any(), any());
    }
}
