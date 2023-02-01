package com.globant.exercise.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherResponse {
    @JsonProperty("coord")
    public Coord coord;
    @JsonProperty("weather")
    public ArrayList<Weather> weather;
    @JsonProperty("base")
    public String base;
    @JsonProperty("main")
    public Main main;
    @JsonProperty("visibility")
    public int visibility;
    @JsonProperty("wind")
    public Wind wind;
    @JsonProperty("clouds")
    public Clouds clouds;
    @JsonProperty("dt")
    public int dt;
    @JsonProperty("sys")
    public Sys sys;
    @JsonProperty("timezone")
    public int timezone;
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("cod")
    public int cod;
}
