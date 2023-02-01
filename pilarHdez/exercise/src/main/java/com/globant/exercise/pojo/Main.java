package com.globant.exercise.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Main {
    @JsonProperty("temp")
    public double temp;
    @JsonProperty("feels_like")
    public double feelsLike;
    @JsonProperty("temp_min")
    public double tempMin;
    @JsonProperty("temp_max")
    public double tempMax;
    @JsonProperty("pressure")
    public int pressure;
    @JsonProperty("humidity")
    public int humidity;
    @JsonProperty("sea_level")
    public int seaLevel;
    @JsonProperty("grnd_level")
    public int grndLevel;
}
