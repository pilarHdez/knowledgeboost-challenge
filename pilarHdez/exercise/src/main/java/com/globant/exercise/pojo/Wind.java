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
public class Wind {
    @JsonProperty("speed")
    public double speed;
    @JsonProperty("deg")
    public int deg;
    @JsonProperty("gust")
    public double gust;
}
