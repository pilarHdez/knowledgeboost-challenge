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
public class Coord {
    @JsonProperty("lon")
    public int lon;
    @JsonProperty("lat")
    public int lat;
}
