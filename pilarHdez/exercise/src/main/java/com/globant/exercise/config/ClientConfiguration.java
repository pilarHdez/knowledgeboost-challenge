package com.globant.exercise.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {
    @Bean
    Logger.Level feingLoggerLevel() {
        return Logger.Level.FULL;
    }
}
