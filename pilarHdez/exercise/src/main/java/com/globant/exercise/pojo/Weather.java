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
public class Weather {
    @JsonProperty("id")
    public int id;
    @JsonProperty("main")
    public String main;
    @JsonProperty("description")
    public String description;
    @JsonProperty("icon")
    public String icon;
}
