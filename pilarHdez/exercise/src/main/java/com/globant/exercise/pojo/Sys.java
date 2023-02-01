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
public class Sys {
    @JsonProperty("country")
    public String country;
    @JsonProperty("sunrise")
    public int sunrise;
    @JsonProperty("sunset")
    public int sunset;
}
